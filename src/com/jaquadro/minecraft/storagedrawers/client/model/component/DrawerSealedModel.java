package com.jaquadro.minecraft.storagedrawers.client.model.component;

import com.jaquadro.minecraft.chameleon.Chameleon;
import com.jaquadro.minecraft.chameleon.model.WrappedChamModel;
import com.jaquadro.minecraft.chameleon.render.ChamRender;
import com.jaquadro.minecraft.storagedrawers.StorageDrawers;
import com.jaquadro.minecraft.storagedrawers.core.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;

public class DrawerSealedModel extends WrappedChamModel
{
    public DrawerSealedModel (IBakedModel model, IBlockState state, boolean mergeLayers) {
        super(model, state, mergeLayers);
    }

    @Override
    protected void renderMippedLayer (ChamRender renderer, IBlockState state, Object... args) {
        float depth = ModBlocks.basicDrawers.isHalfDepth(state) ? .5f : 1f;
        TextureAtlasSprite iconTape = Chameleon.instance.iconRegistry.getIcon(StorageDrawers.proxy.iconTapeCover);

        ChamRender.instance.startBaking(DefaultVertexFormats.ITEM, 0);
        ChamRender.instance.setRenderBounds(0, 0, .995f - depth, 1, 1, 1);
        ChamRender.instance.bakeFace(ChamRender.FACE_ZNEG, state, iconTape, false);
        ChamRender.instance.stopBaking();
    }
}
