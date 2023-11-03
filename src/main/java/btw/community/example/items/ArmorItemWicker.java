// FCMOD

package btw.community.example.items;

import btw.item.items.ArmorItemMod;
import net.minecraft.src.EnumArmorMaterial;

public class ArmorItemWicker extends ArmorItemMod
{
	static final int RENDER_INDEX = 1;
	private final int enchantability = 0; // can not be enchanted normally

    public ArmorItemWicker(int iItemID, int iArmorType )
    {
        super(iItemID, EnumArmorMaterial.CLOTH, RENDER_INDEX, iArmorType, 0); // we're overriding the material
     
        setMaxDamage( getMaxDamage() >> 1  ); // 1/2 that of leather        
        
        setBuoyant();
        setIncineratedInCrucible();
    }
    @Override
	public String getWornTexturePrefix()
    {
    	return "lxWicker";
    }    
    
    @Override
    public int getItemEnchantability()
    {
        return enchantability;
    }
}
