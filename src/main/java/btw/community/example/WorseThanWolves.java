package btw.community.example;

import btw.AddonHandler;
import btw.BTWAddon;
import btw.block.BTWBlocks;
import btw.community.example.items.ArmorItemWicker;
import btw.community.example.items.BonePickCarving;
import btw.crafting.recipe.RecipeManager;
import btw.item.BTWItems;
import btw.item.items.BoneCarvingItem;
import btw.item.items.PickaxeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class WorseThanWolves extends BTWAddon {
    private static WorseThanWolves instance;
    public static Item wicker_helmet;
    public static Item wicker_chestplate;
    public static Item wicker_leggings;
    public static Item wicker_boots;
    public static Item unfinished_bone_pick;
    public static Item bone_pick_head;
    public static Item bone_pick;

    private WorseThanWolves() {
        super("Worse Than Wolves", "0.0.1", "WTW");
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " version " + this.getVersionString() + " initializing...");
        wicker_helmet = new ArmorItemWicker(31990,0).setUnlocalizedName("lxItemWickerHelmet").setCreativeTab(CreativeTabs.tabCombat);
        wicker_chestplate = new ArmorItemWicker(31991,1).setUnlocalizedName("lxItemWickerChestplate").setCreativeTab(CreativeTabs.tabCombat);
        wicker_leggings = new ArmorItemWicker(31992,2).setUnlocalizedName("lxItemWickerLeggings").setCreativeTab(CreativeTabs.tabCombat);
        wicker_boots = new ArmorItemWicker(31993,3).setUnlocalizedName("lxItemWickerBoots").setCreativeTab(CreativeTabs.tabCombat);
        unfinished_bone_pick = new BonePickCarving(31994).setUnlocalizedName("lxUnfinishedBonePick");
        bone_pick_head = new Item(31995).setUnlocalizedName("lxItemBonePickaxeHead").setCreativeTab(CreativeTabs.tabMisc);
        bone_pick = new PickaxeItem(31996,EnumToolMaterial.WOOD,8).setUnlocalizedName("lxItemBonePickaxe");
        AddonHandler.logMessage("hopefully adding recipes...");
        RecipeManager.addRecipe(new ItemStack(WorseThanWolves.wicker_helmet, 1 ), new Object[] {
                "WWW",
                "W W",
                'W', BTWItems.wickerPane
        });
        RecipeManager.addRecipe(new ItemStack(WorseThanWolves.wicker_chestplate, 1 ), new Object[] {
                "W W",
                "WWW",
                "WWW",
                'W', BTWItems.wickerPane
        });
        RecipeManager.addRecipe(new ItemStack(WorseThanWolves.wicker_leggings, 1 ), new Object[] {
                "WWW",
                "W W",
                "W W",
                'W', BTWItems.wickerPane
        });
        RecipeManager.addRecipe(new ItemStack(WorseThanWolves.wicker_boots, 1 ), new Object[] {
                "W W",
                "W W",
                'W', BTWItems.wickerPane
        });
        RecipeManager.addRecipe(new ItemStack(WorseThanWolves.unfinished_bone_pick, 1, BonePickCarving.DEFAULT_MAX_DAMAGE - 1 ), new Object[] {
                "BB",
                "B ",
                'B', new ItemStack(Item.bone)
        });
        RecipeManager.addRecipe(new ItemStack(WorseThanWolves.unfinished_bone_pick, 1, BonePickCarving.DEFAULT_MAX_DAMAGE - 1 ), new Object[] {
                " B",
                "BB",
                'B', new ItemStack(Item.bone)
        });
        RecipeManager.addRecipe(new ItemStack(WorseThanWolves.bone_pick, 1 ), new Object[] {
                "BS",
                "I",
                'B', new ItemStack(WorseThanWolves.bone_pick_head),
                'I', new ItemStack(Item.stick),
                'S', new ItemStack(Item.silk)
        });
        AddonHandler.logMessage("done! have a nice play!");
    }

    public static WorseThanWolves getInstance() {
        if (instance == null)
            instance = new WorseThanWolves();
        return instance;
    }

}
