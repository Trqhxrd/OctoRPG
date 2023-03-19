package me.trqhxrd.octorpg.item.attribute

import me.trqhxrd.octorpg.api.OctoRPG
import me.trqhxrd.octorpg.api.registry.Registry
import me.trqhxrd.octorpg.item.attribute.base.Durability
import me.trqhxrd.octorpg.item.attribute.base.Lore
import me.trqhxrd.octorpg.item.attribute.base.Named
import org.bukkit.NamespacedKey

class ItemAttributeRegistry(val octoRPG: OctoRPG, registerDefaults: Boolean = true) :
    Registry<NamespacedKey, ItemAttribute.AttributeBuilder<out ItemAttribute>>() {

    init {
        if (registerDefaults) {
            this.add(Named.Builder(this.octoRPG))
            this.add(Lore.Builder(this.octoRPG))
            this.add(Durability.Builder(this.octoRPG))
        }
    }

    fun instantiate(key: NamespacedKey) = this.get(key).build()

    fun instantiateOrNull(key: NamespacedKey) = this.getOrNull(key)?.build()
}