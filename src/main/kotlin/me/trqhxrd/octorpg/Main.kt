package me.trqhxrd.octorpg

import me.trqhxrd.octorpg.api.OctoRPG
import me.trqhxrd.octorpg.debug.PlayerJoinListener
import org.bukkit.Bukkit
import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import java.io.File

class Main : JavaPlugin {

    lateinit var instance: OctoRPG
        private set

    constructor() : super()

    constructor(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File) :
            super(
                loader,
                description,
                dataFolder,
                file
            )

    override fun onEnable() {
        this.instance = OctoRPG(this)
        Bukkit.getPluginManager().registerEvents(PlayerJoinListener(this.instance), this)

        this.logger.info("Hello World!")
    }
}