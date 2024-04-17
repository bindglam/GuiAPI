package io.github.bindglam.guiapi.utils

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ItemCreator {
    var itemStack: ItemStack

    constructor(type: Material){
        itemStack = ItemStack(type)
    }

    constructor(itemStack: ItemStack){
        this.itemStack = itemStack
    }

    fun displayName(): Component? {
        return itemStack.itemMeta.displayName()
    }

    fun displayName(displayName: Component?): ItemCreator {
        val meta = itemStack.itemMeta
        meta.displayName(displayName)
        itemStack.itemMeta = meta
        return this
    }

    fun lore(): List<Component>? {
        return itemStack.itemMeta.lore()
    }

    fun lore(lore: List<Component>?): ItemCreator {
        val meta = itemStack.itemMeta
        meta.lore(lore)
        itemStack.itemMeta = meta
        return this
    }
}