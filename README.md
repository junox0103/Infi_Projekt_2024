Als Projekt mach ich eine Datenbank für ein Gefängnis. Die Hauptelemente sollen die Insassen Zellen und Personal sein. Die Insassen haben Eigenschaften wie Name alter die verurteilten Jahre Ranking des Verbrechens und das Verbrechen spezifisch. Die Beamten sollen alter, Name und Sicherheitsausrüstungslevel haben. Zellen sollen einen Namen welcher Gleichzeitig die id ist zb.(a,b,c) und den Platz haben. 

Ich verwende ormlite und mysql.  

Hauptziele: 

Spezifische Insassen in einer Text File mithilfe der Insassen ID geben ausgeben. 
Many2Many Beziehungen zwischen bewachenden Personal und bewachten Insassen
One2Many zwischen Zellen und Insassen.

Nebenziele: 

Trigger verwenden um den Code möglichst einfach zu halten  

 
