package com.example.examplemod.item;

<<<<<<< HEAD
import com.example.examplemod.skill.ModSwordSkill;
=======
>>>>>>> a3466a8302166c45fdaddfa324a647ec28977f0a
import net.java.games.input.Controller;
import net.java.games.input.Keyboard;
import net.minecraft.block.BlockTNT;
import net.minecraft.client.Minecraft;
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
<<<<<<< HEAD
public class PoisonSword extends ToolSword implements ModSwordSkill {
=======
public class PoisonSword extends ToolSword{
>>>>>>> a3466a8302166c45fdaddfa324a647ec28977f0a
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
    @SideOnly(Side.CLIENT)
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        (new Thread(new ThreadRunMinecreaft(target,4))).start();
        return super.hitEntity(stack, target, attacker);
    }

    private void drawCircle(EntityLivingBase attacker,int r) throws InterruptedException {
        WorldClient world = Minecraft.getMinecraft().world;
        for (double i = -1*r;i <= r;i += 0.1){
            double d = r - Math.pow(i,2);
            world.spawnParticle(EnumParticleTypes.LAVA, attacker.posX+i, attacker.posY, attacker.posZ+Math.sqrt(d), 0.0D, 0.0D, 0.0D);
            Thread.sleep(10);
        }
        for (double i = r;i >= -1*r;i -= 0.1){
            double d = r - Math.pow(i,2);
            world.spawnParticle(EnumParticleTypes.LAVA, attacker.posX+i, attacker.posY, attacker.posZ+(Math.sqrt(d)*-1), 0.0D, 0.0D, 0.0D);
            Thread.sleep(10);
            
        }
    }

<<<<<<< HEAD
    @Override
    public void skill1() {
        System.out.println("一技能");
    }

    @Override
    public void skill2() {
        System.out.println("二技能");
    }

    @Override
    public void skill3() {
        System.out.println("三技能");
    }

=======
>>>>>>> a3466a8302166c45fdaddfa324a647ec28977f0a
    public class ThreadRunMinecreaft implements Runnable{
        EntityLivingBase entity;
        int r;
        public ThreadRunMinecreaft(EntityLivingBase entity,int r) {
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
