package uk.ac.mmu.game.applicationcode.domain.player;

import uk.ac.mmu.game.applicationcode.domain.entities.Player;

interface PlayerSelector {

  Player next();
}