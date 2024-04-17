package io.github.bindglam.guiapi.commands

import io.github.bindglam.guiapi.Gui
import io.github.bindglam.guiapi.Node
import io.github.bindglam.guiapi.utils.ItemCreator
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.joml.Vector2i

class TestCommand : CommandExecutor {
    override fun onCommand(player: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(player !is Player || !command.label.equals("test-gui", true)) return false

        object : Gui(9*6, Component.text("테스트 메뉴")) {
            init {
                contents.add(Node.Button({ event ->
                    val player = event.whoClicked as Player
                    player.sendMessage("사과할게")
                }, ItemCreator(Material.APPLE).itemStack, Vector2i(1, 1), Vector2i(2, 3)))
            }

            override fun onClick(event: InventoryClickEvent) {
                event.isCancelled = true
            }
        }.open(player)
        return true
    }
}