/*
 * Project: UHC
 * Class: gg.uhc.uhc.modules.reset.resetters.FullPlayerResetter
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Graham Howden <graham_howden1 at yahoo.co.uk>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package gg.uhc.uhc.modules.reset.resetters;

import gg.uhc.uhc.modules.reset.actions.*;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class FullPlayerResetter extends PlayerResetter {

    public FullPlayerResetter(Plugin plugin, long cacheTicks) {
        super(plugin, cacheTicks);
    }

    @Override
    protected Action getActionForPlayer(Player player) {
        final UUID uuid = player.getUniqueId();

        return new ComboAction(
                uuid,
                new ClearInventoryAction(uuid),
                new ClearPotionEffectsAction(uuid),
                new ClearXPAction(uuid),
                new FullHealthAction(uuid),
                new FullHungerAction(uuid)
        );
    }
}
