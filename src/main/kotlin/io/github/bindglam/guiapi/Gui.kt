package io.github.bindglam.guiapi

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.joml.Vector2i

abstract class Gui : Listener {
    var inv: Inventory
    var invView: InventoryView? = null

    val contents = arrayListOf<Node>()

    constructor(size: Int, title: Component){
        inv = Bukkit.createInventory(null, size, title)

        Bukkit.getPluginManager().registerEvents(this, GuiAPI.INSTANCE)
    }

    constructor(type: InventoryType, title: Component){
        inv = Bukkit.createInventory(null, type, title)

        Bukkit.getPluginManager().registerEvents(this, GuiAPI.INSTANCE)
    }

    abstract fun onClick(event: InventoryClickEvent)

    private fun placeContents(){
        for(node in contents){
            node.place(inv)
        }
    }

    fun open(player: Player){
        placeContents()

        invView = player.openInventory(inv)
    }

    @EventHandler
    fun onInvClick(event: InventoryClickEvent){
        if(event.view == invView){
            onClick(event)

            for(node in contents){
                node.onClick(event)
            }
        }
    }
}