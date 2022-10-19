package com.example.examplemod.item;

import com.example.examplemod.skill.ModSwordSkill;
import net.java.games.input.Controller;
import net.java.games.input.Keyboard;
import net.minecraft.block.BlockTNT;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.ParticleFootStep;
import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.settings.KeyBindingMap;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class PoisonSword extends ToolSword implements ModSwordSkill {
    public static final Item.ToolMaterial POISON = EnumHelper.addToolMaterial("emerald",4,15610,10.0F,4.0F,10);
    public PoisonSword() {
        super("poison_sword", POISON);
    }
    @SubscribeEvent
    public static void onAttack(LivingHurtEvent event){
        World world = event.getEntity().getEntityWorld();
        EntityLivingBase hurt = event.getEntityLiving();
        Entity source = event.getSource().getTrueSource();
        if (source instanceof EntityLivingBase) {
            EntityLivingBase attacker = (EntityLivingBase) source;
            if (world.isRemote || event.isCanceled()) {
                return;
            }
            if(attacker.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof PoisonSword){
                hurt.addPotionEffect(new PotionEffect(MobEffects.POISON,20*5));
            }
        }

    }

    private void drawCircle(Vec3d attacker,int r) throws InterruptedException {
        WorldClient world = Minecraft.getMinecraft().world;
        for (double i = -1*r;i <= r;i += 0.1){
            double d = r - Math.pow(i,2);
            world.spawnParticle(EnumParticleTypes.LAVA, attacker.x+i, attacker.y, attacker.z+Math.sqrt(d), 0.0D, 0.0D, 0.0D);
        }
        for (double i = r;i >= -1*r;i -= 0.1){
            double d = r - Math.pow(i,2);
            world.spawnParticle(EnumParticleTypes.LAVA, attacker.x+i, attacker.y, attacker.z+(Math.sqrt(d)*-1), 0.0D, 0.0D, 0.0D);

        }
    }

    @Override
    public void skill1() {
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        Vec3d lookVec = player.getLookVec();

        Vec3d vec3d = new Vec3d(lookVec.x, 0, lookVec.z).normalize();

        Vec3d position = player.getPositionVector().add(vec3d.scale(10f));
        System.out.println(position.toString());
        (new Thread(new ThreadRunMinecreaft(position,10))).start();
    }

    @Override
    public void skill2() {
        System.out.println("二技能");
    }

    @Override
    public void skill3() {
        System.out.println("三技能");
    }

    public class ThreadRunMinecreaft implements Runnable{
        Vec3d entity;
        int r;
        public ThreadRunMinecreaft(Vec3d entity,int r) {
            this.entity = entity;
            this.r = r;
        }


        @Override
        public void run() {
            try {
                drawCircle(this.entity,this.r);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
