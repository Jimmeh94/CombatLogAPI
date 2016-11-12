# CombatLogAPI
Sponge Vanilla based combat log API

Each EntityInfo has a list of EntryContainers.
These containers belong to each attacker that has attacked that entity within the current "combat" session.
Every attack that hits the entity gets its CombatEntry added to its (the attacker's) container.

This allows for lists of attacks from multiple different attackers, organized neatly.
It will make for exp and reward distribution easy.
