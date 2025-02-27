// FCMOD

package btw.community.example.items;

import btw.community.example.WorseThanWolves;
import btw.item.items.ProgressiveCraftingItem;
import net.minecraft.src.*;

public class BonePickCarving extends ProgressiveCraftingItem
{
    public BonePickCarving(int iItemID )
    {
    	super( iItemID );
    	
        setBuoyant();
        setFilterableProperties(Item.FILTERABLE_SMALL);
        
        setUnlocalizedName( "lxBonePickaxeUnfinished" );
    }
    
    @Override
    protected void playCraftingFX(ItemStack stack, World world, EntityPlayer player)
    {
        player.playSound( "random.eat", 
        	0.5F + 0.5F * (float)world.rand.nextInt( 2 ), 
        	( world.rand.nextFloat() * 0.25F ) + 1.25F );
        
        spawnUseParticles(stack, world, player);
    }
    
    @Override
    public ItemStack onEaten( ItemStack stack, World world, EntityPlayer player )
    {
		player.playSound( "mob.zombie.woodbreak", 0.1F, 1.25F + ( world.rand.nextFloat() * 0.25F ) );
        
        return new ItemStack(WorseThanWolves.bone_pick_head, 1, 0 );
    }
    
    @Override
    public void onCreated( ItemStack stack, World world, EntityPlayer player ) 
    {
		if (player.timesCraftedThisTick == 0 && world.isRemote )
		{
			player.playSound( "mob.zombie.woodbreak", 0.1F, 1.25F + ( world.rand.nextFloat() * 0.25F ) );
		}
		
    	super.onCreated( stack, world, player );
    }
    
    //------------- Class Specific Methods ------------//
    
    protected void spawnUseParticles(ItemStack stack, World world, EntityPlayer player)
    {
	    if ( world.isRemote )
	    {
	        Vec3 velVec = world.getWorldVec3Pool().getVecFromPool(
	        	( world.rand.nextFloat() - 0.5D ) * 0.1D, Math.random() * 0.1D + 0.1D, 0D );
	        
	        velVec.rotateAroundX( -player.rotationPitch * (float)Math.PI / 180F );
	        velVec.rotateAroundY( -player.rotationYaw * (float)Math.PI / 180F );
	        
	        Vec3 posVec = world.getWorldVec3Pool().getVecFromPool(
	        	( world.rand.nextFloat() - 0.5D ) * 0.3D,
	        	( -world.rand.nextFloat()) * 0.6D - 0.3D, 0.6D );
	        
	        posVec.rotateAroundX( -player.rotationPitch * (float)Math.PI / 180F );
	        posVec.rotateAroundY( -player.rotationYaw * (float)Math.PI / 180F );
	        
	        posVec = posVec.addVector( player.posX, player.posY + player.getEyeHeight(), player.posZ );
	        
	        world.spawnParticle( "iconcrack_" + stack.getItem().itemID, 
	        	posVec.xCoord, posVec.yCoord, posVec.zCoord, 
	        	velVec.xCoord, velVec.yCoord + 0.05D, velVec.zCoord );
	    }
    }
    
	//------------ Client Side Functionality ----------//
}
