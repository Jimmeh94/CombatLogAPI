# CombatLogAPI
Sponge Vanilla based combat log API

This keeps track of every time an entity is attacked, what and who attacked it, and for how much damage.
Once an entity enters combat, it will need to have X seconds out of combat to truly be "out of combat".

EntityInfo's contain CombatEntityEntry's that hold the damage, attack and attacker names.
Whenever an entity is hit, their info files need to be updated with a new CombatEntityEntry for that attack.
