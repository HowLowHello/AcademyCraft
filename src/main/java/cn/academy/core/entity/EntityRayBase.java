/**
 * Copyright (c) Lambda Innovation, 2013-2015
 * 本作品版权由Lambda Innovation所有。
 * http://www.li-dev.cn/
 *
 * This project is open-source, and it is distributed under  
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package cn.academy.core.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import org.lwjgl.util.vector.Vector2f;

import cn.liutils.entityx.EntityAdvanced;

/**
 * @author WeAthFolD
 *
 */
public class EntityRayBase extends EntityAdvanced implements IRay {

	public EntityRayBase(World world) {
		super(world);
	}
	
	@Override
	public Vec3 getPosition() {
		return Vec3.createVectorHelper(posX, posY, posZ);
	}

	@Override
	public double getLength() {
		return 15;
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound tag) {
		posX = tag.getDouble("x");
		posY = tag.getDouble("y");
		posZ = tag.getDouble("z");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag) {
		tag.setDouble("x", posX);
		tag.setDouble("y", posY);
		tag.setDouble("z", posZ);
	}

	@Override
	public Vec3 getLookingDirection() {
		return Vec3.createVectorHelper(motionX, motionY, motionZ);
	}

}