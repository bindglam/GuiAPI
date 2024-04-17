package io.github.bindglam.guiapi

import io.github.bindglam.guiapi.commands.TestCommand
import org.bukkit.plugin.java.JavaPlugin

class GuiAPI : JavaPlugin() {
    override fun onEnable() {
        INSTANCE = this

        getCommand("test-gui")?.setExecutor(TestCommand())
    }

    override fun onDisable() {
    }

    companion object{
        lateinit var INSTANCE: GuiAPI
    }
}