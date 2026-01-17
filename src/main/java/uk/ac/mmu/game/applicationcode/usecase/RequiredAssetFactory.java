package uk.ac.mmu.game.applicationcode.usecase;

import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;

public interface RequiredAssetFactory {

  AssetFactory getAssetFactory();
}
