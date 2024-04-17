package io.github.bindglam.guiapi

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.joml.Vector2i
import java.util.function.Consumer

open class Node(val action: Consumer<InventoryClickEvent>, val itemStack: ItemStack, val position: Vector2i) {
    open fun place(inv: Inventory){
        inv.setItem(position.y*9+position.x, itemStack)
    }

    open fun onClick(event: InventoryClickEvent){
    }

    class Button(action: Consumer<InventoryClickEvent>, itemStack: ItemStack, position: Vector2i, val size: Vector2i) : Node(action, itemStack, position) {
        override fun place(inv: Inventory) {
            for(x in 0..<size.x) {
                for (y in 0..<size.y) {
                    inv.setItem((position.y+y)*9+(position.x+x), itemStack)
                }
            }
        }

        override fun onClick(event: InventoryClickEvent) {
            for(x in 0..<size.x){
                for(y in 0..<size.y){
                    if(event.rawSlot == (position.y+y)*9+(position.x+x)){
                        action.accept(event)
                    }
                }
            }
        }
    }
}