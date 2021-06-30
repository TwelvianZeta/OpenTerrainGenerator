package com.pg85.otg.gen.resource;

import java.util.List;
import java.util.Random;

import com.pg85.otg.config.biome.BiomeResourceBase;
import com.pg85.otg.exception.InvalidConfigException;
import com.pg85.otg.util.interfaces.IBiomeConfig;
import com.pg85.otg.util.interfaces.ILogger;
import com.pg85.otg.util.interfaces.IMaterialReader;
import com.pg85.otg.util.interfaces.IWorldGenRegion;

public class RegistryResource  extends BiomeResourceBase implements IBasicResource
{
	private final String id;

	public RegistryResource(IBiomeConfig biomeConfig, List<String> args, ILogger logger, IMaterialReader materialReader) throws InvalidConfigException
	{
		super(biomeConfig, args, logger, materialReader);
		assureSize(1, args);

		this.id = args.get(0);
	}

	@Override
	public void spawnForChunkDecoration(IWorldGenRegion worldGenRegion, Random random, boolean villageInChunk, ILogger logger, IMaterialReader materialReader)
	{
		worldGenRegion.placeFromRegistry(random, worldGenRegion.getDecorationArea().getChunkBeingDecorated(), this.id);
	}
	
	@Override
	public String toString()
	{
		return "Registry(" + this.id + ")";
	}	
}
