package com.pg85.otg.gen.resource;

import java.util.List;
import java.util.Random;

import com.pg85.otg.config.biome.BiomeResourceBase;
import com.pg85.otg.constants.Constants;
import com.pg85.otg.util.interfaces.IBiomeConfig;
import com.pg85.otg.util.interfaces.ILogger;
import com.pg85.otg.util.interfaces.IMaterialReader;
import com.pg85.otg.util.interfaces.IWorldGenRegion;

public abstract class FrequencyResourceBase extends BiomeResourceBase implements IBasicResource
{
	protected int frequency;
	protected double rarity;
	
	public FrequencyResourceBase(IBiomeConfig biomeConfig, List<String> args, ILogger logger, IMaterialReader materialReader)
	{
		super(biomeConfig, args, logger, materialReader);
	}

	@Override
	public void spawnForChunkDecoration(IWorldGenRegion worldGenRegion, Random random, boolean villageInChunk, ILogger logger, IMaterialReader materialReader)
	{
		int blockX = worldGenRegion.getDecorationArea().getChunkBeingDecoratedCenterX();
		int blockZ = worldGenRegion.getDecorationArea().getChunkBeingDecoratedCenterZ();		

		for (int t = 0; t < this.frequency; t++)
		{
			if (random.nextDouble() * 100.0 > this.rarity)
			{
				continue;
			}
			int x = blockX + random.nextInt(Constants.CHUNK_SIZE);
			int z = blockZ + random.nextInt(Constants.CHUNK_SIZE);
			spawn(worldGenRegion, random, false, x, z);
		}
	}

	public abstract void spawn(IWorldGenRegion world, Random random, boolean villageInChunk, int x, int z);	
}
