package com.tartiflex.dofuscraft.mixin;

import com.tartiflex.dofuscraft.Dofuscraft;
import com.tartiflex.dofuscraft.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    private List<Item> itemsWith3dModel = List.of(
            ModItems.RAZIELLE
    );

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel use3dModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(itemsWith3dModel.contains(stack.getItem()) && renderMode != ModelTransformationMode.GUI) {
            String item3dModelName = stack.getItem().getName().getString().toLowerCase() + "_3d";
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Dofuscraft.MOD_ID, item3dModelName, "inventory"));
        }
        return value;
    }
}
