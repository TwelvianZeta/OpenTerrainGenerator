package com.pg85.otg.fabric.api;

import com.pg85.otg.interfaces.IBiomeConfig;
import com.pg85.otg.paper.gen.OTGNoiseChunkGenerator;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

import java.util.Optional;

public class OTGPaperAPI
{
	public static IBiomeConfig getOTGBiome(Location location)
	{
		ServerLevel world = ((CraftWorld) location.getWorld()).getHandle();

		if (!(world.getChunkSource().getGenerator() instanceof OTGNoiseChunkGenerator))
		{
			return null;
		}

		return ((OTGNoiseChunkGenerator) world.getChunkSource().generator).getCachedBiomeProvider()
				.getBiomeConfig(location.getBlockX(), location.getBlockZ());
	}

	public static Optional<IBiomeConfig> getOTGBiomeOptional(Location location)
	{
		return Optional.ofNullable(getOTGBiome(location));
	}
}
