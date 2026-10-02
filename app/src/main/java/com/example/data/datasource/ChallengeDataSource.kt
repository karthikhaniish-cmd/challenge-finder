package com.example.data.datasource

import com.example.data.model.Challenge

object ChallengeDataSource {
    val challenges: List<Challenge> = listOf(
        // --- FUNNY (1-12) ---
        Challenge(
            id = 1,
            title = "Don't Laugh Challenge",
            description = "Keep a completely straight face while a friend or video tries to make you laugh for 60 seconds.",
            category = "funny",
            difficulty = "medium",
            duration = 60,
            points = 50
        ),
        Challenge(
            id = 2,
            title = "Robot Mode",
            description = "Talk and move exactly like a mechanical robot for 2 full minutes.",
            category = "funny",
            difficulty = "easy",
            duration = 120,
            points = 25
        ),
        Challenge(
            id = 3,
            title = "Sports Commentator",
            description = "Narrate whatever mundane thing you or someone else is doing right now like a high-stakes championship commentator.",
            category = "funny",
            difficulty = "easy",
            duration = 90,
            points = 30
        ),
        Challenge(
            id = 4,
            title = "Silent Comedy Act",
            description = "Try to explain what you had for lunch or breakfast using only silent gestures and dramatic facial expressions.",
            category = "funny",
            difficulty = "medium",
            duration = 60,
            points = 45
        ),
        Challenge(
            id = 5,
            title = "Red Carpet Walk",
            description = "Strut across the room like a diva or superstar arriving at a glamorous movie premiere, waving to imaginary paparazzi.",
            category = "funny",
            difficulty = "easy",
            duration = 45,
            points = 20
        ),
        Challenge(
            id = 6,
            title = "Question Master",
            description = "Speak exclusively in questions for 3 continuous minutes. You lose if you make a direct statement.",
            category = "funny",
            difficulty = "hard",
            duration = 180,
            points = 75
        ),
        Challenge(
            id = 7,
            title = "Breaking News Anchor",
            description = "Pretend you are an urgent news reporter breaking the latest shocking headline about a missing sock or misplaced cup.",
            category = "funny",
            difficulty = "medium",
            duration = 90,
            points = 55
        ),
        Challenge(
            id = 8,
            title = "Alien Anthropologist",
            description = "Examine a nearby household object (like a fork or pen) and describe its mysterious cosmic purpose as if you're an extraterrestrial.",
            category = "funny",
            difficulty = "medium",
            duration = 90,
            points = 50
        ),
        Challenge(
            id = 9,
            title = "Movie Trailer Voice",
            description = "Deliver your next three sentences in the deep, dramatic 'In a world...' Hollywood blockbuster movie trailer voice.",
            category = "funny",
            difficulty = "easy",
            duration = 60,
            points = 25
        ),
        Challenge(
            id = 10,
            title = "Slow Motion Replay",
            description = "Perform a simple task like drinking water or picking up a notebook in ultra slow-motion for a full minute.",
            category = "funny",
            difficulty = "medium",
            duration = 60,
            points = 40
        ),
        Challenge(
            id = 11,
            title = "The Opera Conversation",
            description = "Sing whatever you want to say next in a high-pitch operatic soprano or booming baritone melody.",
            category = "funny",
            difficulty = "hard",
            duration = 60,
            points = 80
        ),
        Challenge(
            id = 12,
            title = "T-Rex Arms",
            description = "Tuck your elbows tightly to your sides and do everything with tiny dinosaur hands for the next 2 minutes.",
            category = "funny",
            difficulty = "easy",
            duration = 120,
            points = 30
        ),

        // --- BRAIN (13-24) ---
        Challenge(
            id = 13,
            title = "10 Countries Blitz",
            description = "Name 10 different countries out loud within 20 seconds without repeating.",
            category = "brain",
            difficulty = "easy",
            duration = 20,
            points = 25
        ),
        Challenge(
            id = 14,
            title = "Mental Math Marathon",
            description = "Calculate in your head: start at 100, subtract 7 consecutively down to under 50 as fast as possible.",
            category = "brain",
            difficulty = "medium",
            duration = 45,
            points = 45
        ),
        Challenge(
            id = 15,
            title = "Number Memory Grid",
            description = "Read this sequence once: '9 4 1 7 3 8 2 6', look away immediately, and repeat it backwards.",
            category = "brain",
            difficulty = "hard",
            duration = 30,
            points = 75
        ),
        Challenge(
            id = 16,
            title = "Alliteration Storm",
            description = "Invent a coherent 7-word sentence where every single word begins with the same letter.",
            category = "brain",
            difficulty = "medium",
            duration = 60,
            points = 50
        ),
        Challenge(
            id = 17,
            title = "Riddle Resolver",
            description = "Solve this: 'I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?' (Answer: A map!)",
            category = "brain",
            difficulty = "easy",
            duration = 40,
            points = 30
        ),
        Challenge(
            id = 18,
            title = "Category 15 Sprint",
            description = "Pick a letter and name 15 animals, cities, or foods starting with it within 60 seconds.",
            category = "brain",
            difficulty = "medium",
            duration = 60,
            points = 60
        ),
        Challenge(
            id = 19,
            title = "Word Association Chain",
            description = "Say 30 connected words where each word links naturally to the previous (e.g. Tree -> Leaf -> Green -> Grass) without hesitation.",
            category = "brain",
            difficulty = "hard",
            duration = 60,
            points = 80
        ),
        Challenge(
            id = 20,
            title = "Stroop Speed Test",
            description = "Look around the room and name the COLOR of 10 items without naming what the items actually are.",
            category = "brain",
            difficulty = "easy",
            duration = 30,
            points = 20
        ),
        Challenge(
            id = 21,
            title = "Rhyme Machine",
            description = "Pick any word (like 'Light') and find 10 words that rhyme with it in under 30 seconds.",
            category = "brain",
            difficulty = "medium",
            duration = 30,
            points = 40
        ),
        Challenge(
            id = 22,
            title = "Reverse Spelling",
            description = "Spell out five 6-letter words backwards out loud without writing them down.",
            category = "brain",
            difficulty = "hard",
            duration = 75,
            points = 85
        ),
        Challenge(
            id = 23,
            title = "Trivia Mastermind",
            description = "Recall and state 3 interesting historical or scientific facts you learned in school.",
            category = "brain",
            difficulty = "easy",
            duration = 60,
            points = 25
        ),
        Challenge(
            id = 24,
            title = "Anagram Solver",
            description = "Unscramble these letters into valid words: 'L-I-S-T-E-N' (Silent, Tinsel) and 'P-O-S-T' (Stop, Spot, Tops).",
            category = "brain",
            difficulty = "medium",
            duration = 45,
            points = 50
        ),

        // --- FITNESS (25-36) ---
        Challenge(
            id = 25,
            title = "Squat Power 15",
            description = "Perform 15 clean, controlled bodyweight squats with proper posture and steady breathing.",
            category = "fitness",
            difficulty = "easy",
            duration = 45,
            points = 30
        ),
        Challenge(
            id = 26,
            title = "Plank Endurance",
            description = "Hold a solid forearm plank with engaged core for 30 seconds straight.",
            category = "fitness",
            difficulty = "medium",
            duration = 30,
            points = 45
        ),
        Challenge(
            id = 27,
            title = "Jumping Jack Blast",
            description = "Complete 25 rhythmic jumping jacks to get your heart rate going.",
            category = "fitness",
            difficulty = "easy",
            duration = 45,
            points = 25
        ),
        Challenge(
            id = 28,
            title = "Desk Stretcher",
            description = "Perform shoulder rolls, neck tilts, hamstring stretches, and torso twists for 90 seconds.",
            category = "fitness",
            difficulty = "easy",
            duration = 90,
            points = 20
        ),
        Challenge(
            id = 29,
            title = "Wall Sit Champion",
            description = "Hold an active 90-degree wall sit for 45 continuous seconds.",
            category = "fitness",
            difficulty = "hard",
            duration = 45,
            points = 75
        ),
        Challenge(
            id = 30,
            title = "High Knees Blitz",
            description = "Pump your arms and sprint on the spot bringing knees up to hip height for 30 seconds.",
            category = "fitness",
            difficulty = "medium",
            duration = 30,
            points = 50
        ),
        Challenge(
            id = 31,
            title = "Calf Raise Burner",
            description = "Perform 30 continuous calf raises on a flat surface, pausing briefly at the peak.",
            category = "fitness",
            difficulty = "easy",
            duration = 45,
            points = 25
        ),
        Challenge(
            id = 32,
            title = "Push-Up Stride",
            description = "Do 12 good form push-ups (standard or knee push-ups).",
            category = "fitness",
            difficulty = "medium",
            duration = 60,
            points = 55
        ),
        Challenge(
            id = 33,
            title = "Posture Reset",
            description = "Stand flat against a wall, touching your heels, hips, shoulders, and head for 60 seconds with deep breaths.",
            category = "fitness",
            difficulty = "easy",
            duration = 60,
            points = 20
        ),
        Challenge(
            id = 34,
            title = "Pacing 2-Minute Walk",
            description = "Get up right now and walk at a brisk pace around your room, home, or hallway for 2 minutes.",
            category = "fitness",
            difficulty = "easy",
            duration = 120,
            points = 30
        ),
        Challenge(
            id = 35,
            title = "Balance Flamingo",
            description = "Stand on your left leg for 30 seconds with eyes closed, then switch to your right leg for 30 seconds.",
            category = "fitness",
            difficulty = "hard",
            duration = 60,
            points = 80
        ),
        Challenge(
            id = 36,
            title = "Glute Bridge Set",
            description = "Lie on your back and complete 20 controlled glute bridges, squeezing at the top.",
            category = "fitness",
            difficulty = "medium",
            duration = 60,
            points = 45
        ),

        // --- CREATIVE (37-48) ---
        Challenge(
            id = 37,
            title = "Blindfolded Doodling",
            description = "Close your eyes or blindfold yourself and draw a bicycle or elephant on paper.",
            category = "creative",
            difficulty = "easy",
            duration = 60,
            points = 30
        ),
        Challenge(
            id = 38,
            title = "Three-Word Micro Story",
            description = "Invent a captivating 30-second story containing the words: 'Astronaut', 'Pancake', and 'Cello'.",
            category = "creative",
            difficulty = "medium",
            duration = 60,
            points = 50
        ),
        Challenge(
            id = 39,
            title = "Superhero Creator",
            description = "Invent a unique superhero, their origin story, unusual weakness, and signature catchphrase.",
            category = "creative",
            difficulty = "medium",
            duration = 120,
            points = 55
        ),
        Challenge(
            id = 40,
            title = "One-Line Movie Pitch",
            description = "Write a hilarious one-sentence elevator pitch for a Hollywood romantic comedy about competing chefs.",
            category = "creative",
            difficulty = "easy",
            duration = 60,
            points = 25
        ),
        Challenge(
            id = 41,
            title = "Origami or Paper Figurine",
            description = "Fold a piece of scrap paper into a paper airplane, swan, hat, or mini bookmark.",
            category = "creative",
            difficulty = "medium",
            duration = 120,
            points = 50
        ),
        Challenge(
            id = 42,
            title = "Six-Word Memoir",
            description = "Craft a profound or humorous life story summarized in exactly six words.",
            category = "creative",
            difficulty = "hard",
            duration = 90,
            points = 75
        ),
        Challenge(
            id = 43,
            title = "Invention Blueprint",
            description = "Sketch or explain a gadget that solves a tiny annoying problem in everyday life.",
            category = "creative",
            difficulty = "medium",
            duration = 120,
            points = 60
        ),
        Challenge(
            id = 44,
            title = "Haiku Composition",
            description = "Write a poetic haiku (5-7-5 syllables) about coffee, mornings, or coding.",
            category = "creative",
            difficulty = "medium",
            duration = 90,
            points = 45
        ),
        Challenge(
            id = 45,
            title = "New Language Slang",
            description = "Invent 3 brand new slang words, define their meanings, and use them in realistic dialogue.",
            category = "creative",
            difficulty = "easy",
            duration = 60,
            points = 30
        ),
        Challenge(
            id = 46,
            title = "Commercial Jingle",
            description = "Sing an original catchy 15-second musical jingle advertising ordinary tap water.",
            category = "creative",
            difficulty = "hard",
            duration = 60,
            points = 80
        ),
        Challenge(
            id = 47,
            title = "Photo Scavenger Shot",
            description = "Take a high-concept artistic photo using dramatic lighting and ordinary desk shadows.",
            category = "creative",
            difficulty = "easy",
            duration = 90,
            points = 30
        ),
        Challenge(
            id = 48,
            title = "Fictional Kingdom Law",
            description = "Draft three whimsical laws for an imaginary fantasy island where cats rule as nobility.",
            category = "creative",
            difficulty = "easy",
            duration = 60,
            points = 25
        ),

        // --- SOCIAL (49-60) ---
        Challenge(
            id = 49,
            title = "Heartfelt Compliment",
            description = "Send a thoughtful, sincere message complimenting a friend or family member on a quality you admire.",
            category = "social",
            difficulty = "easy",
            duration = 90,
            points = 30
        ),
        Challenge(
            id = 50,
            title = "Memory Lane Check-In",
            description = "Message an old friend sharing a funny shared memory from the past.",
            category = "social",
            difficulty = "medium",
            duration = 120,
            points = 50
        ),
        Challenge(
            id = 51,
            title = "The Movie Poll",
            description = "Ask someone what movie made them laugh or cry the hardest and why.",
            category = "social",
            difficulty = "easy",
            duration = 60,
            points = 25
        ),
        Challenge(
            id = 52,
            title = "Gratitude Spark",
            description = "Thank someone who helped or supported you recently with an appreciative note.",
            category = "social",
            difficulty = "easy",
            duration = 60,
            points = 30
        ),
        Challenge(
            id = 53,
            title = "High-Five Spree",
            description = "Give a genuine high-five, fist-bump, or warm greeting to three people today.",
            category = "social",
            difficulty = "easy",
            duration = 0,
            points = 25
        ),
        Challenge(
            id = 54,
            title = "Recommend a Song",
            description = "Send your favorite uplifting song to someone who might need positive energy today.",
            category = "social",
            difficulty = "easy",
            duration = 60,
            points = 20
        ),
        Challenge(
            id = 55,
            title = "Active Listener",
            description = "In your next conversation, listen completely without interrupting for at least 3 minutes, then summarize what they said.",
            category = "social",
            difficulty = "hard",
            duration = 180,
            points = 75
        ),
        Challenge(
            id = 56,
            title = "Random Act of Kindness",
            description = "Do a quick unprompted favor for someone in your household or workspace (e.g., make tea, clean up a dish).",
            category = "social",
            difficulty = "medium",
            duration = 180,
            points = 55
        ),
        Challenge(
            id = 57,
            title = "Ask for Advice",
            description = "Ask a colleague or friend for their perspective or recommendation on a topic they are knowledgeable about.",
            category = "social",
            difficulty = "medium",
            duration = 120,
            points = 45
        ),
        Challenge(
            id = 58,
            title = "Book or Podcast Swap",
            description = "Ask someone about the most interesting thing they've read or listened to this month.",
            category = "social",
            difficulty = "easy",
            duration = 60,
            points = 25
        ),
        Challenge(
            id = 59,
            title = "Voice Note Surprise",
            description = "Leave a cheerful 30-second audio voice note to a loved one wishing them a productive, awesome day.",
            category = "social",
            difficulty = "medium",
            duration = 60,
            points = 50
        ),
        Challenge(
            id = 60,
            title = "Public Appreciation",
            description = "Leave a positive 5-star review for a small local business or indie creator you like.",
            category = "social",
            difficulty = "hard",
            duration = 180,
            points = 80
        ),

        // --- GAMING (61-72) ---
        Challenge(
            id = 61,
            title = "Random Character Roulette",
            description = "In your next video game round, select a character or loadout you have never or rarely played with.",
            category = "gaming",
            difficulty = "easy",
            duration = 0,
            points = 30
        ),
        Challenge(
            id = 62,
            title = "Pacifist Run / No Damage",
            description = "Attempt a level or mission in your favorite game without taking any avoidable damage.",
            category = "gaming",
            difficulty = "hard",
            duration = 0,
            points = 90
        ),
        Challenge(
            id = 63,
            title = "Default Weapon Trial",
            description = "Win a match or beat a stage using only the starter basic weapon or ability.",
            category = "gaming",
            difficulty = "hard",
            duration = 0,
            points = 85
        ),
        Challenge(
            id = 64,
            title = "Personal High Score Hunt",
            description = "Beat your top score or time in any arcade, puzzle, or mobile game.",
            category = "gaming",
            difficulty = "medium",
            duration = 0,
            points = 60
        ),
        Challenge(
            id = 65,
            title = "Inverted Controls Dare",
            description = "Play 5 minutes of a racing or flying game with controls or camera axis inverted.",
            category = "gaming",
            difficulty = "hard",
            duration = 300,
            points = 80
        ),
        Challenge(
            id = 66,
            title = "Speed Run Sprint",
            description = "Complete an entire stage or checkpoint twice as fast as your usual casual pace.",
            category = "gaming",
            difficulty = "medium",
            duration = 0,
            points = 55
        ),
        Challenge(
            id = 67,
            title = "Co-op MVP",
            description = "Play a multiplayer match focusing 100% on supporting, healing, or pinging for teammates.",
            category = "gaming",
            difficulty = "medium",
            duration = 0,
            points = 50
        ),
        Challenge(
            id = 68,
            title = "No Map / HUD Challenge",
            description = "Turn off the mini-map or HUD display for one match and navigate purely by environmental cues.",
            category = "gaming",
            difficulty = "hard",
            duration = 0,
            points = 75
        ),
        Challenge(
            id = 69,
            title = "Clean Up Inventory",
            description = "Organize, scrap, or sell your cluttered in-game inventory and clean up your storage chest.",
            category = "gaming",
            difficulty = "easy",
            duration = 180,
            points = 25
        ),
        Challenge(
            id = 70,
            title = "Retro Classic Run",
            description = "Play a round of a retro classic like Tetris, Pac-Man, or Snake and reach stage 5.",
            category = "gaming",
            difficulty = "easy",
            duration = 180,
            points = 30
        ),
        Challenge(
            id = 71,
            title = "Flawless Rhythm",
            description = "Play a rhythm or music game stage achieving 90%+ note accuracy.",
            category = "gaming",
            difficulty = "medium",
            duration = 180,
            points = 65
        ),
        Challenge(
            id = 72,
            title = "Teach a Mechanic",
            description = "Explain a complex game strategy or lore element clearly to someone who doesn't play.",
            category = "gaming",
            difficulty = "easy",
            duration = 120,
            points = 25
        ),

        // --- STUDY (73-84) ---
        Challenge(
            id = 73,
            title = "15-Minute Focus Sprint",
            description = "Put your phone in another room or on Do Not Disturb and study or read without any interruption for 15 minutes.",
            category = "study",
            difficulty = "medium",
            duration = 900,
            points = 65
        ),
        Challenge(
            id = 74,
            title = "Feynman Technique",
            description = "Explain a complex concept or algorithm in plain English as if explaining it to a 10-year-old.",
            category = "study",
            difficulty = "easy",
            duration = 120,
            points = 30
        ),
        Challenge(
            id = 75,
            title = "Flashcard 5 Blitz",
            description = "Memorize 5 technical terms, vocabulary words, or formulas until you can recall them flawlessly.",
            category = "study",
            difficulty = "medium",
            duration = 300,
            points = 45
        ),
        Challenge(
            id = 76,
            title = "3-Sentence Summary",
            description = "Read an article or textbook chapter and condense its central thesis into exactly three clear sentences.",
            category = "study",
            difficulty = "easy",
            duration = 180,
            points = 30
        ),
        Challenge(
            id = 77,
            title = "Solve 5 Practice Problems",
            description = "Work through and complete 5 test or practice questions from start to finish.",
            category = "study",
            difficulty = "hard",
            duration = 600,
            points = 75
        ),
        Challenge(
            id = 78,
            title = "Mind Map Sketch",
            description = "Draw a visual diagram connecting 8 sub-topics of a subject you want to master.",
            category = "study",
            difficulty = "medium",
            duration = 240,
            points = 50
        ),
        Challenge(
            id = 79,
            title = "Desk Declutter Sweep",
            description = "Clear everything off your study desk except your notepad, pen, and computer.",
            category = "study",
            difficulty = "easy",
            duration = 120,
            points = 20
        ),
        Challenge(
            id = 80,
            title = "New Language Word Trio",
            description = "Learn how to say and write 3 useful phrases in a foreign language (e.g. Japanese, Spanish, German).",
            category = "study",
            difficulty = "easy",
            duration = 180,
            points = 25
        ),
        Challenge(
            id = 81,
            title = "Teach the Wall",
            description = "Stand up and give a 2-minute lecture aloud to the wall about what you studied today.",
            category = "study",
            difficulty = "medium",
            duration = 120,
            points = 50
        ),
        Challenge(
            id = 82,
            title = "Quiz Maker",
            description = "Create 3 tricky multiple-choice questions on your favorite topic with explanations.",
            category = "study",
            difficulty = "medium",
            duration = 240,
            points = 55
        ),
        Challenge(
            id = 83,
            title = "Wikipedia Rabbit Hole",
            description = "Hit 'Random Article' on Wikipedia and read the entire page, taking away one fascinating insight.",
            category = "study",
            difficulty = "easy",
            duration = 180,
            points = 25
        ),
        Challenge(
            id = 84,
            title = "Deep Work 30-Minute Marathon",
            description = "Engage in uninterrupted, deeply focused reading, writing, or coding for 30 minutes straight.",
            category = "study",
            difficulty = "hard",
            duration = 1800,
            points = 100
        ),

        // --- DARE (85-96) ---
        Challenge(
            id = 85,
            title = "Celebrity Impression",
            description = "Deliver your best impression of a famous celebrity, animated character, or movie star for 30 seconds.",
            category = "dare",
            difficulty = "easy",
            duration = 30,
            points = 30
        ),
        Challenge(
            id = 86,
            title = "The Dramatic Monologue",
            description = "Deliver a totally serious Shakespearean-style speech lamenting why your battery is low or why toast gets burnt.",
            category = "dare",
            difficulty = "medium",
            duration = 60,
            points = 50
        ),
        Challenge(
            id = 87,
            title = "Silly Nickname Proclamation",
            description = "Announce to your friends or family that for the next hour, they must refer to you as 'Captain Awesome'.",
            category = "dare",
            difficulty = "easy",
            duration = 60,
            points = 25
        ),
        Challenge(
            id = 88,
            title = "Clean Joke Delivery",
            description = "Tell a family-friendly pun or dad joke to someone and make them chuckle or groan.",
            category = "dare",
            difficulty = "easy",
            duration = 45,
            points = 20
        ),
        Challenge(
            id = 89,
            title = "Rhyming Responses",
            description = "Every sentence you say to anyone for the next 2 minutes must end with a rhyming pair.",
            category = "dare",
            difficulty = "hard",
            duration = 120,
            points = 80
        ),
        Challenge(
            id = 90,
            title = "Statue Freeze",
            description = "Freeze completely like an ancient museum marble statue for 45 seconds without blinking or moving.",
            category = "dare",
            difficulty = "easy",
            duration = 45,
            points = 25
        ),
        Challenge(
            id = 91,
            title = "Accent Switch",
            description = "Adopt a foreign or regional accent (British, French, Texan, Australian) and speak in it for 2 minutes.",
            category = "dare",
            difficulty = "medium",
            duration = 120,
            points = 55
        ),
        Challenge(
            id = 92,
            title = "Send a Random Emoji Chain",
            description = "Send your best friend a cryptic message of 5 random emojis with zero context.",
            category = "dare",
            difficulty = "easy",
            duration = 30,
            points = 20
        ),
        Challenge(
            id = 93,
            title = "Opposite Day",
            description = "Respond with opposite reactions (nodding for no, shaking head for yes) for the next 3 interactions.",
            category = "dare",
            difficulty = "medium",
            duration = 90,
            points = 45
        ),
        Challenge(
            id = 94,
            title = "Praise a Rival",
            description = "Publicly admit and praise three things that your rival sports team or competing brand actually does well.",
            category = "dare",
            difficulty = "medium",
            duration = 60,
            points = 50
        ),
        Challenge(
            id = 95,
            title = "Unusual Dance Groove",
            description = "Invent a bizarre 15-second signature victory dance routine and perform it with full conviction.",
            category = "dare",
            difficulty = "easy",
            duration = 30,
            points = 30
        ),
        Challenge(
            id = 96,
            title = "Truth or Dare Champion",
            description = "Share the most embarrassing (yet wholesome) fashion or haircut phase you had as a teenager.",
            category = "dare",
            difficulty = "hard",
            duration = 60,
            points = 75
        ),

        // --- QUICK (97-108) ---
        Challenge(
            id = 97,
            title = "10 Animals in 15s",
            description = "Name 10 wild animals out loud before the 15-second countdown finishes.",
            category = "quick",
            difficulty = "easy",
            duration = 15,
            points = 20
        ),
        Challenge(
            id = 98,
            title = "Cat Quick-Sketch",
            description = "Draw a cute cartoon cat on paper or in a doodle app in under 30 seconds.",
            category = "quick",
            difficulty = "easy",
            duration = 30,
            points = 25
        ),
        Challenge(
            id = 99,
            title = "Backward Alphabet Sprint",
            description = "Recite the English alphabet backwards from Z down to P in under 20 seconds.",
            category = "quick",
            difficulty = "medium",
            duration = 20,
            points = 40
        ),
        Challenge(
            id = 100,
            title = "Find Something Blue",
            description = "Locate 3 distinctly blue objects within reach in under 15 seconds.",
            category = "quick",
            difficulty = "easy",
            duration = 15,
            points = 15
        ),
        Challenge(
            id = 101,
            title = "Hydration Quick Chug",
            description = "Stand up and drink a full glass of cool water right now in under 20 seconds.",
            category = "quick",
            difficulty = "easy",
            duration = 20,
            points = 20
        ),
        Challenge(
            id = 102,
            title = "Tongue Twister Triple",
            description = "Say 'She sells seashells by the seashore' three times rapidly without stumbling.",
            category = "quick",
            difficulty = "medium",
            duration = 20,
            points = 35
        ),
        Challenge(
            id = 103,
            title = "20 Quick Jumping Jacks",
            description = "Knock out 20 fast jumping jacks in under 25 seconds.",
            category = "quick",
            difficulty = "easy",
            duration = 25,
            points = 25
        ),
        Challenge(
            id = 104,
            title = "5 Deep Belly Breaths",
            description = "Inhale deep for 4 seconds, hold for 4 seconds, exhale for 4 seconds. Complete 5 cycles.",
            category = "quick",
            difficulty = "easy",
            duration = 60,
            points = 20
        ),
        Challenge(
            id = 105,
            title = "Thumb Wrestling Match",
            description = "Challenge a friend (or pit your left thumb against your right thumb) in a 30-second duel: 1, 2, 3, 4, I declare a thumb war!",
            category = "quick",
            difficulty = "easy",
            duration = 30,
            points = 20
        ),
        Challenge(
            id = 106,
            title = "Count by 3s to 30",
            description = "Count aloud: 3, 6, 9, 12, 15, 18, 21, 24, 27, 30 in under 10 seconds.",
            category = "quick",
            difficulty = "easy",
            duration = 10,
            points = 20
        ),
        Challenge(
            id = 107,
            title = "Pocket Pat Check",
            description = "Organize everything in your pockets or desk tray into neat piles within 45 seconds.",
            category = "quick",
            difficulty = "easy",
            duration = 45,
            points = 20
        ),
        Challenge(
            id = 108,
            title = "High Speed Clap 50",
            description = "Clap your hands 50 times as quickly as you possibly can.",
            category = "quick",
            difficulty = "medium",
            duration = 20,
            points = 35
        )
    )

    fun getDailyChallenge(daySeed: Long): Challenge {
        val index = (daySeed % challenges.size).toInt()
        return challenges[if (index < 0) index + challenges.size else index]
    }
}
