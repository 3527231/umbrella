package com.example.examplemod.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class CircleParticle extends Particle {
    public CircleParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
    }

}
