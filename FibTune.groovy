if (args.length < 1) {
   println("Usage: groovy FibTune.groovy words")
   return
}

fibMap = [
   'I':'1', 'J':'1', 'U':'1', 'V':'1', 'Y':'1',
   'H':'3', 'L':'3', 'N':'3', 'R':'3', 'X':'3',
   'A':'4', 'E':'4', 'O':'4', 'Q':'4',
   'B':'5', 'C':'5', 'F':'5', 'G':'5', 'S':'5', 'Z':'5',
   'D':'7', 'K':'7', 'M':'7', 'P':'7', 'T':'7', 'W':'7'
]

nafNoteMap = [ '1':'F#', '3':'A', '4':'B', '5':'c#', '7':'e' ]
abcNoteMap = [ '1':'F', '3':'A', '4':'B', '5':'c', '7':'e' ]

words = args[0]
chars = words.toUpperCase().toList()

title = "Fibsong: " + words
nafTracksNotes = title + '\n'
flutetreeNotes = "Title: " + title + "\n[L:1/4][W:5]\n"
abcNotes = "X:1\nT:" + title + "\nM:1/4\nL:1/4\nK:C#m\n"

count = 0
barCount = 0

for (int i = 0; i < chars.size(); i ++) {
   c = chars[i]

   if (fibMap.containsKey(c)) {
      n = fibMap[c]
      nafTracksNotes += n + ' '
      flutetreeNotes += nafNoteMap[n] + ' '
      abcNotes += abcNoteMap[n] + ' '
      count ++

      if ((count % 4) == 0) {
         nafTracksNotes += ' '
         flutetreeNotes += '|'
         abcNotes += '|'
         barCount ++

         if ((barCount % 5) == 0) {
            nafTracksNotes += '\n\n'
            flutetreeNotes += '\n'
            abcNotes += '\n'
         } else {
            nafTracksNotes += ' '
            flutetreeNotes += ' '
            abcNotes += ' '
         }
      }
   }
}

nafTracksNotes = nafTracksNotes.trim()
flutetreeNotes = flutetreeNotes.trim()
abcNotes = abcNotes.trim()

if (!flutetreeNotes.endsWith("|")) {
   flutetreeNotes += " |"
}

flutetreeNotes += "]"

if (!abcNotes.endsWith("|")) {
   abcNotes += " |"
}

abcNotes += "]"

println("NAF Tracks Six Hole (36 point)")
println("----------------------------------------------------")
println(nafTracksNotes)

println("")

println("Flutetree Songbook")
println("----------------------------------------------------")
println(flutetreeNotes)

println("")

println("ABC")
println("----------------------------------------------------")
println(abcNotes)
