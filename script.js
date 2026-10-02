/**
 * Random Challenge Generator (ChallengeGen)
 * Production JavaScript Engine
 */

// ==========================================
// 1. CHALLENGE DATABASE (108 Unique Challenges)
// ==========================================
const CHALLENGES_DATABASE = [
  // --- FUNNY (1-12) ---
  { id: 1, title: "Don't Laugh Challenge", description: "Try to keep a completely serious face while your friend tries to make you laugh for 60 seconds.", category: "funny", difficulty: "medium", duration: 60, points: 50 },
  { id: 2, title: "Robot Mode", description: "Talk and move like a mechanical robot for 2 straight minutes.", category: "funny", difficulty: "easy", duration: 120, points: 25 },
  { id: 3, title: "Sports Commentator", description: "Explain whatever mundane thing you or someone else is doing right now like a high-stakes championship commentator.", category: "funny", difficulty: "easy", duration: 90, points: 30 },
  { id: 4, title: "Silent Comedy Act", description: "Explain what you had for your last meal using only silent facial expressions and gestures.", category: "funny", difficulty: "medium", duration: 60, points: 45 },
  { id: 5, title: "Red Carpet Walk", description: "Walk across the room like a diva or superstar entering a red carpet, waving to imaginary paparazzi.", category: "funny", difficulty: "easy", duration: 45, points: 20 },
  { id: 6, title: "Question Master", description: "Speak exclusively using questions for 3 continuous minutes.", category: "funny", difficulty: "hard", duration: 180, points: 75 },
  { id: 7, title: "Breaking News Anchor", description: "Pretend you are an urgent news reporter broadcasting the latest shocking headline about a misplaced pencil.", category: "funny", difficulty: "medium", duration: 90, points: 55 },
  { id: 8, title: "Alien Anthropologist", description: "Hold an ordinary household object and describe its mysterious cosmic purpose as if you are an extraterrestrial.", category: "funny", difficulty: "medium", duration: 90, points: 50 },
  { id: 9, title: "Movie Trailer Voice", description: "Deliver your next three sentences in the dramatic 'In a world...' Hollywood blockbuster voice.", category: "funny", difficulty: "easy", duration: 60, points: 25 },
  { id: 10, title: "Slow Motion Replay", description: "Perform a simple task like drinking water in ultra slow-motion for a full minute.", category: "funny", difficulty: "medium", duration: 60, points: 40 },
  { id: 11, title: "The Opera Conversation", description: "Sing whatever you want to say next in a high-pitch operatic soprano or booming baritone melody.", category: "funny", difficulty: "hard", duration: 60, points: 80 },
  { id: 12, title: "T-Rex Arms", description: "Tuck your elbows to your sides and do everything with tiny dinosaur hands for the next 2 minutes.", category: "funny", difficulty: "easy", duration: 120, points: 30 },

  // --- BRAIN (13-24) ---
  { id: 13, title: "10 Countries Blitz", description: "Name 10 countries out loud in 20 seconds without repeating.", category: "brain", difficulty: "easy", duration: 20, points: 25 },
  { id: 14, title: "Mental Math Sprint", description: "Start at 100 and count downwards subtracting 7 consecutively (100, 93, 86...) in your head.", category: "brain", difficulty: "medium", duration: 45, points: 45 },
  { id: 15, title: "Number Memory Grid", description: "Read this sequence once: '9 4 1 7 3 8 2 6', look away immediately, and recite it backwards.", category: "brain", difficulty: "hard", duration: 30, points: 75 },
  { id: 16, title: "Alliteration Storm", description: "Invent a coherent 7-word sentence where every word begins with the same letter.", category: "brain", difficulty: "medium", duration: 60, points: 50 },
  { id: 17, title: "Riddle Resolver", description: "Solve this riddle: 'I have cities, but no houses. I have mountains, but no trees. What am I?' (Answer: A map!)", category: "brain", difficulty: "easy", duration: 40, points: 30 },
  { id: 18, title: "Category 15 Sprint", description: "Pick a letter and name 15 animals, cities, or foods starting with it within 60 seconds.", category: "brain", difficulty: "medium", duration: 60, points: 60 },
  { id: 19, title: "Word Association Chain", description: "Say 30 connected words where each word links logically to the previous without pausing.", category: "brain", difficulty: "hard", duration: 60, points: 80 },
  { id: 20, title: "Stroop Speed Test", description: "Look around you and name the COLOR of 10 items without naming the objects.", category: "brain", difficulty: "easy", duration: 30, points: 20 },
  { id: 21, title: "Rhyme Machine", description: "Pick any word (like 'Light') and find 10 words that rhyme with it in under 30 seconds.", category: "brain", difficulty: "medium", duration: 30, points: 40 },
  { id: 22, title: "Reverse Spelling", description: "Spell out five 6-letter words backwards out loud without writing them down.", category: "brain", difficulty: "hard", duration: 75, points: 85 },
  { id: 23, title: "Trivia Mastermind", description: "Recall and state 3 interesting historical or scientific facts you learned in school.", category: "brain", difficulty: "easy", duration: 60, points: 25 },
  { id: 24, title: "Anagram Solver", description: "Unscramble these letters into valid words: 'L-I-S-T-E-N' (Silent, Tinsel) and 'P-O-S-T' (Stop, Spot, Tops).", category: "brain", difficulty: "medium", duration: 45, points: 50 },

  // --- FITNESS (25-36) ---
  { id: 25, title: "Squat Power 15", description: "Perform 15 clean, controlled bodyweight squats with proper posture and steady breathing.", category: "fitness", difficulty: "easy", duration: 45, points: 30 },
  { id: 26, title: "Plank Endurance", description: "Hold a solid forearm plank with engaged core for 30 seconds straight.", category: "fitness", difficulty: "medium", duration: 30, points: 45 },
  { id: 27, title: "Jumping Jack Blast", description: "Complete 25 rhythmic jumping jacks to elevate your circulation.", category: "fitness", difficulty: "easy", duration: 45, points: 25 },
  { id: 28, title: "Desk Stretcher", description: "Perform shoulder rolls, neck tilts, hamstring stretches, and torso twists for 90 seconds.", category: "fitness", difficulty: "easy", duration: 90, points: 20 },
  { id: 29, title: "Wall Sit Champion", description: "Hold an active 90-degree wall sit for 45 continuous seconds.", category: "fitness", difficulty: "hard", duration: 45, points: 75 },
  { id: 30, title: "High Knees Blitz", description: "Sprint on the spot bringing your knees up to hip height for 30 seconds.", category: "fitness", difficulty: "medium", duration: 30, points: 50 },
  { id: 31, title: "Calf Raise Burner", description: "Perform 30 continuous calf raises on a flat surface, pausing briefly at the peak.", category: "fitness", difficulty: "easy", duration: 45, points: 25 },
  { id: 32, title: "Push-Up Stride", description: "Do 12 good form push-ups (standard or knee push-ups).", category: "fitness", difficulty: "medium", duration: 60, points: 55 },
  { id: 33, title: "Posture Reset", description: "Stand flat against a wall, touching your heels, hips, shoulders, and head for 60 seconds with deep breaths.", category: "fitness", difficulty: "easy", duration: 60, points: 20 },
  { id: 34, title: "Pacing 2-Minute Walk", description: "Walk at a brisk pace around your room, home, or hallway for 2 minutes.", category: "fitness", difficulty: "easy", duration: 120, points: 30 },
  { id: 35, title: "Balance Flamingo", description: "Stand on your left leg for 30 seconds with eyes closed, then switch to your right leg for 30 seconds.", category: "fitness", difficulty: "hard", duration: 60, points: 80 },
  { id: 36, title: "Glute Bridge Set", description: "Lie on your back and complete 20 controlled glute bridges, squeezing at the top.", category: "fitness", difficulty: "medium", duration: 60, points: 45 },

  // --- CREATIVE (37-48) ---
  { id: 37, title: "Blindfolded Doodling", description: "Close your eyes or blindfold yourself and draw a bicycle or elephant on paper.", category: "creative", difficulty: "easy", duration: 60, points: 30 },
  { id: 38, title: "Three-Word Micro Story", description: "Invent a captivating 30-second story containing the words: 'Astronaut', 'Pancake', and 'Cello'.", category: "creative", difficulty: "medium", duration: 60, points: 50 },
  { id: 39, title: "Superhero Creator", description: "Design a superhero name, their origin story, unusual weakness, and signature catchphrase.", category: "creative", difficulty: "medium", duration: 120, points: 55 },
  { id: 40, title: "One-Line Movie Pitch", description: "Write a hilarious one-sentence elevator pitch for a Hollywood romantic comedy about competing chefs.", category: "creative", difficulty: "easy", duration: 60, points: 25 },
  { id: 41, title: "Origami / Paper Character", description: "Fold a piece of scrap paper into a paper airplane, swan, hat, or mini bookmark.", category: "creative", difficulty: "medium", duration: 120, points: 50 },
  { id: 42, title: "Six-Word Memoir", description: "Craft a profound or humorous life story summarized in exactly six words.", category: "creative", difficulty: "hard", duration: 90, points: 75 },
  { id: 43, title: "Invention Blueprint", description: "Sketch or explain a gadget that solves a tiny annoying problem in everyday life.", category: "creative", difficulty: "medium", duration: 120, points: 60 },
  { id: 44, title: "Haiku Composition", description: "Write a poetic haiku (5-7-5 syllables) about coffee, mornings, or coding.", category: "creative", difficulty: "medium", duration: 90, points: 45 },
  { id: 45, title: "New Slang Words", description: "Invent 3 brand new slang words, define their meanings, and use them in realistic dialogue.", category: "creative", difficulty: "easy", duration: 60, points: 30 },
  { id: 46, title: "Commercial Jingle", description: "Sing an original catchy 15-second musical jingle advertising ordinary tap water.", category: "creative", difficulty: "hard", duration: 60, points: 80 },
  { id: 47, title: "Photo Scavenger Shot", description: "Take a high-concept artistic photo using dramatic lighting and ordinary desk shadows.", category: "creative", difficulty: "easy", duration: 90, points: 30 },
  { id: 48, title: "Fictional Kingdom Law", description: "Draft three whimsical laws for an imaginary fantasy island where cats rule as nobility.", category: "creative", difficulty: "easy", duration: 60, points: 25 },

  // --- SOCIAL (49-60) ---
  { id: 49, title: "Heartfelt Compliment", description: "Send a thoughtful, sincere message complimenting a friend or family member on a quality you admire.", category: "social", difficulty: "easy", duration: 90, points: 30 },
  { id: 50, title: "Memory Lane Check-In", description: "Message an old friend sharing a funny shared memory from the past.", category: "social", difficulty: "medium", duration: 120, points: 50 },
  { id: 51, title: "The Movie Poll", description: "Ask someone what movie made them laugh or cry the hardest and why.", category: "social", difficulty: "easy", duration: 60, points: 25 },
  { id: 52, title: "Gratitude Spark", description: "Thank someone who helped or supported you recently with an appreciative note.", category: "social", difficulty: "easy", duration: 60, points: 30 },
  { id: 53, title: "High-Five Spree", description: "Give a genuine high-five, fist-bump, or warm greeting to three people today.", category: "social", difficulty: "easy", duration: 0, points: 25 },
  { id: 54, title: "Recommend a Song", description: "Send your favorite uplifting song to someone who might need positive energy today.", category: "social", difficulty: "easy", duration: 60, points: 20 },
  { id: 55, title: "Active Listener", description: "In your next conversation, listen completely without interrupting for at least 3 minutes, then summarize what they said.", category: "social", difficulty: "hard", duration: 180, points: 75 },
  { id: 56, title: "Random Act of Kindness", description: "Do a quick unprompted favor for someone in your household or workspace (e.g., make tea, clean up a dish).", category: "social", difficulty: "medium", duration: 180, points: 55 },
  { id: 57, title: "Ask for Advice", description: "Ask a colleague or friend for their perspective or recommendation on a topic they are knowledgeable about.", category: "social", difficulty: "medium", duration: 120, points: 45 },
  { id: 58, title: "Book or Podcast Swap", description: "Ask someone about the most interesting thing they've read or listened to this month.", category: "social", difficulty: "easy", duration: 60, points: 25 },
  { id: 59, title: "Voice Note Surprise", description: "Leave a cheerful 30-second audio voice note to a loved one wishing them a productive, awesome day.", category: "social", difficulty: "medium", duration: 60, points: 50 },
  { id: 60, title: "Public Appreciation", description: "Leave a positive 5-star review for a small local business or indie creator you like.", category: "social", difficulty: "hard", duration: 180, points: 80 },

  // --- GAMING (61-72) ---
  { id: 61, title: "Random Character Roulette", description: "In your next video game round, select a character or loadout you have never or rarely played with.", category: "gaming", difficulty: "easy", duration: 0, points: 30 },
  { id: 62, title: "Pacifist Run / No Damage", description: "Attempt a level or mission in your favorite game without taking any avoidable damage.", category: "gaming", difficulty: "hard", duration: 0, points: 90 },
  { id: 63, title: "Default Weapon Trial", description: "Win a match or beat a stage using only the starter basic weapon or ability.", category: "gaming", difficulty: "hard", duration: 0, points: 85 },
  { id: 64, title: "Personal High Score Hunt", description: "Beat your top score or time in any arcade, puzzle, or mobile game.", category: "gaming", difficulty: "medium", duration: 0, points: 60 },
  { id: 65, title: "Inverted Controls Dare", description: "Play 5 minutes of a racing or flying game with controls or camera axis inverted.", category: "gaming", difficulty: "hard", duration: 300, points: 80 },
  { id: 66, title: "Speed Run Sprint", description: "Complete an entire stage or checkpoint twice as fast as your usual casual pace.", category: "gaming", difficulty: "medium", duration: 0, points: 55 },
  { id: 67, title: "Co-op MVP", description: "Play a multiplayer match focusing 100% on supporting, healing, or pinging for teammates.", category: "gaming", difficulty: "medium", duration: 0, points: 50 },
  { id: 68, title: "No Map / HUD Challenge", description: "Turn off the mini-map or HUD display for one match and navigate purely by environmental cues.", category: "gaming", difficulty: "hard", duration: 0, points: 75 },
  { id: 69, title: "Clean Up Inventory", description: "Organize, scrap, or sell your cluttered in-game inventory and clean up your storage chest.", category: "gaming", difficulty: "easy", duration: 180, points: 25 },
  { id: 70, title: "Retro Classic Run", description: "Play a round of a retro classic like Tetris, Pac-Man, or Snake and reach stage 5.", category: "gaming", difficulty: "easy", duration: 180, points: 30 },
  { id: 71, title: "Flawless Rhythm", description: "Play a rhythm or music game stage achieving 90%+ note accuracy.", category: "gaming", difficulty: "medium", duration: 180, points: 65 },
  { id: 72, title: "Teach a Mechanic", description: "Explain a complex game strategy or lore element clearly to someone who doesn't play.", category: "gaming", difficulty: "easy", duration: 120, points: 25 },

  // --- STUDY (73-84) ---
  { id: 73, title: "15-Minute Focus Sprint", description: "Put your phone in another room or on Do Not Disturb and study or read without any interruption for 15 minutes.", category: "study", difficulty: "medium", duration: 900, points: 65 },
  { id: 74, title: "Feynman Technique", description: "Explain a complex concept or algorithm in plain English as if explaining it to a 10-year-old.", category: "study", difficulty: "easy", duration: 120, points: 30 },
  { id: 75, title: "Flashcard 5 Blitz", description: "Memorize 5 technical terms, vocabulary words, or formulas until you can recall them flawlessly.", category: "study", difficulty: "medium", duration: 300, points: 45 },
  { id: 76, title: "3-Sentence Summary", description: "Read an article or textbook chapter and condense its central thesis into exactly three clear sentences.", category: "study", difficulty: "easy", duration: 180, points: 30 },
  { id: 77, title: "Solve 5 Practice Problems", description: "Work through and complete 5 test or practice questions from start to finish.", category: "study", difficulty: "hard", duration: 600, points: 75 },
  { id: 78, title: "Mind Map Sketch", description: "Draw a visual diagram connecting 8 sub-topics of a subject you want to master.", category: "study", difficulty: "medium", duration: 240, points: 50 },
  { id: 79, title: "Desk Declutter Sweep", description: "Clear everything off your study desk except your notepad, pen, and computer.", category: "study", difficulty: "easy", duration: 120, points: 20 },
  { id: 80, title: "New Language Word Trio", description: "Learn how to say and write 3 useful phrases in a foreign language (e.g. Japanese, Spanish, German).", category: "study", difficulty: "easy", duration: 180, points: 25 },
  { id: 81, title: "Teach the Wall", description: "Stand up and give a 2-minute lecture aloud to the wall about what you studied today.", category: "study", difficulty: "medium", duration: 120, points: 50 },
  { id: 82, title: "Quiz Maker", description: "Create 3 tricky multiple-choice questions on your favorite topic with explanations.", category: "study", difficulty: "medium", duration: 240, points: 55 },
  { id: 83, title: "Wikipedia Rabbit Hole", description: "Hit 'Random Article' on Wikipedia and read the entire page, taking away one fascinating insight.", category: "study", difficulty: "easy", duration: 180, points: 25 },
  { id: 84, title: "Deep Work 30-Minute Marathon", description: "Engage in uninterrupted, deeply focused reading, writing, or coding for 30 minutes straight.", category: "study", difficulty: "hard", duration: 1800, points: 100 },

  // --- DARE (85-96) ---
  { id: 85, title: "Celebrity Impression", description: "Deliver your best impression of a famous celebrity, animated character, or movie star for 30 seconds.", category: "dare", difficulty: "easy", duration: 30, points: 30 },
  { id: 86, title: "The Dramatic Monologue", description: "Deliver a totally serious Shakespearean-style speech lamenting why your battery is low or why toast gets burnt.", category: "dare", difficulty: "medium", duration: 60, points: 50 },
  { id: 87, title: "Silly Nickname Proclamation", description: "Announce to your friends or family that for the next hour, they must refer to you as 'Captain Awesome'.", category: "dare", difficulty: "easy", duration: 60, points: 25 },
  { id: 88, title: "Clean Joke Delivery", description: "Tell a family-friendly pun or dad joke to someone and make them chuckle or groan.", category: "dare", difficulty: "easy", duration: 45, points: 20 },
  { id: 89, title: "Rhyming Responses", description: "Every sentence you say to anyone for the next 2 minutes must end with a rhyming pair.", category: "dare", difficulty: "hard", duration: 120, points: 80 },
  { id: 90, title: "Statue Freeze", description: "Freeze completely like an ancient museum marble statue for 45 seconds without blinking or moving.", category: "dare", difficulty: "easy", duration: 45, points: 25 },
  { id: 91, title: "Accent Switch", description: "Adopt a foreign or regional accent (British, French, Texan, Australian) and speak in it for 2 minutes.", category: "dare", difficulty: "medium", duration: 120, points: 55 },
  { id: 92, title: "Send a Random Emoji Chain", description: "Send your best friend a cryptic message of 5 random emojis with zero context.", category: "dare", difficulty: "easy", duration: 30, points: 20 },
  { id: 93, title: "Opposite Day", description: "Respond with opposite reactions (nodding for no, shaking head for yes) for the next 3 interactions.", category: "dare", difficulty: "medium", duration: 90, points: 45 },
  { id: 94, title: "Praise a Rival", description: "Publicly admit and praise three things that your rival sports team or competing brand actually does well.", category: "dare", difficulty: "medium", duration: 60, points: 50 },
  { id: 95, title: "Unusual Dance Groove", description: "Invent a bizarre 15-second signature victory dance routine and perform it with full conviction.", category: "dare", difficulty: "easy", duration: 30, points: 30 },
  { id: 96, title: "Truth or Dare Champion", description: "Share the most embarrassing (yet wholesome) fashion or haircut phase you had as a teenager.", category: "dare", difficulty: "hard", duration: 60, points: 75 },

  // --- QUICK (97-108) ---
  { id: 97, title: "10 Animals in 15s", description: "Name 10 wild animals out loud before the 15-second countdown finishes.", category: "quick", difficulty: "easy", duration: 15, points: 20 },
  { id: 98, title: "Cat Quick-Sketch", description: "Draw a cute cartoon cat on paper or in a doodle app in under 30 seconds.", category: "quick", difficulty: "easy", duration: 30, points: 25 },
  { id: 99, title: "Backward Alphabet Sprint", description: "Recite the English alphabet backwards from Z down to P in under 20 seconds.", category: "quick", difficulty: "medium", duration: 20, points: 40 },
  { id: 100, title: "Find Something Blue", description: "Locate 3 distinctly blue objects within reach in under 15 seconds.", category: "quick", difficulty: "easy", duration: 15, points: 15 },
  { id: 101, title: "Hydration Quick Chug", description: "Stand up and drink a full glass of cool water right now in under 20 seconds.", category: "quick", difficulty: "easy", duration: 20, points: 20 },
  { id: 102, title: "Tongue Twister Triple", description: "Say 'She sells seashells by the seashore' three times rapidly without stumbling.", category: "quick", difficulty: "medium", duration: 20, points: 35 },
  { id: 103, title: "20 Quick Jumping Jacks", description: "Knock out 20 fast jumping jacks in under 25 seconds.", category: "quick", difficulty: "easy", duration: 25, points: 25 },
  { id: 104, title: "5 Deep Belly Breaths", description: "Inhale deep for 4 seconds, hold for 4 seconds, exhale for 4 seconds. Complete 5 cycles.", category: "quick", difficulty: "easy", duration: 60, points: 20 },
  { id: 105, title: "Thumb Wrestling Match", description: "Challenge a friend (or pit your left thumb against your right thumb) in a 30-second duel: 1, 2, 3, 4, I declare a thumb war!", category: "quick", difficulty: "easy", duration: 30, points: 20 },
  { id: 106, title: "Count by 3s to 30", description: "Count aloud: 3, 6, 9, 12, 15, 18, 21, 24, 27, 30 in under 10 seconds.", category: "quick", difficulty: "easy", duration: 10, points: 20 },
  { id: 107, title: "Pocket Pat Check", description: "Organize everything in your pockets or desk tray into neat piles within 45 seconds.", category: "quick", difficulty: "easy", duration: 45, points: 20 },
  { id: 108, title: "High Speed Clap 50", description: "Clap your hands 50 times as quickly as you possibly can.", category: "quick", difficulty: "medium", duration: 20, points: 35 }
];

const CATEGORIES_CONFIG = [
  { key: "funny", name: "Funny", emoji: "😂", color: "#FF8533" },
  { key: "brain", name: "Brain", emoji: "🧠", color: "#00D4FF" },
  { key: "fitness", name: "Fitness", emoji: "💪", color: "#2ED573" },
  { key: "creative", name: "Creative", emoji: "🎨", color: "#FF4757" },
  { key: "social", name: "Social", emoji: "🎤", color: "#7C5CFC" },
  { key: "gaming", name: "Gaming", emoji: "🎮", color: "#9B51E0" },
  { key: "study", name: "Study", emoji: "📚", color: "#2F80ED" },
  { key: "dare", name: "Dare", emoji: "😈", color: "#FF5252" },
  { key: "quick", name: "Quick", emoji: "⚡", color: "#FFD166" },
  { key: "random", name: "Random", emoji: "🎲", color: "#20BF6B" }
];

// ==========================================
// 2. STATE & STORAGE MANAGEMENT
// ==========================================
let appState = {
  currentChallenge: null,
  selectedCategory: "random",
  selectedDifficulty: "all",
  recentChallengeIds: [],
  score: 0,
  completedCount: 0,
  currentStreak: 0,
  bestStreak: 0,
  lastCompletedDate: "",
  theme: "dark",
  history: []
};

function loadData() {
  try {
    const saved = localStorage.getItem("challengegen_data");
    if (saved) {
      const parsed = JSON.parse(saved);
      appState = { ...appState, ...parsed };
    }
  } catch (e) {
    console.error("Error reading localStorage", e);
  }
}

function saveData() {
  try {
    localStorage.setItem("challengegen_data", JSON.stringify({
      score: appState.score,
      completedCount: appState.completedCount,
      currentStreak: appState.currentStreak,
      bestStreak: appState.bestStreak,
      lastCompletedDate: appState.lastCompletedDate,
      theme: appState.theme,
      history: appState.history,
      recentChallengeIds: appState.recentChallengeIds
    }));
  } catch (e) {
    console.error("Error saving to localStorage", e);
  }
}

// ==========================================
// 3. TIMER SYSTEM
// ==========================================
let timerInterval = null;
let timerTotalSeconds = 0;
let timerRemainingSeconds = 0;
let isTimerRunning = false;
let activeTimerChallenge = null;

function startTimer(challenge) {
  if (!challenge || challenge.duration <= 0) return;
  activeTimerChallenge = challenge;
  timerTotalSeconds = challenge.duration;
  timerRemainingSeconds = challenge.duration;
  isTimerRunning = true;

  document.getElementById("timer-title").textContent = challenge.title;
  document.getElementById("timer-desc").textContent = challenge.description;
  document.getElementById("timer-modal").classList.remove("hidden");

  updateTimerDisplay();
  clearInterval(timerInterval);
  timerInterval = setInterval(tickTimer, 1000);
}

function tickTimer() {
  if (!isTimerRunning) return;
  timerRemainingSeconds--;
  updateTimerDisplay();

  if (timerRemainingSeconds <= 0) {
    clearInterval(timerInterval);
    isTimerRunning = false;
    document.getElementById("timer-modal").classList.add("hidden");
    if (activeTimerChallenge) {
      completeChallenge(activeTimerChallenge);
    }
  }
}

function updateTimerDisplay() {
  const mins = Math.floor(timerRemainingSeconds / 60);
  const secs = timerRemainingSeconds % 60;
  const formatted = `${String(mins).padStart(2, "0")}:${String(secs).padStart(2, "0")}`;
  document.getElementById("timer-display").textContent = formatted;
  document.getElementById("timer-status-label").textContent = isTimerRunning ? "Running" : "Paused";
  document.getElementById("timer-toggle-btn").textContent = isTimerRunning ? "⏸ Pause" : "▶ Resume";

  // SVG Circular progress
  const circle = document.getElementById("timer-progress-circle");
  if (circle && timerTotalSeconds > 0) {
    const circumference = 2 * Math.PI * 70; // r=70
    const offset = circumference * (1 - (timerRemainingSeconds / timerTotalSeconds));
    circle.style.strokeDashoffset = offset;
  }
}

function pauseTimer() {
  isTimerRunning = false;
  updateTimerDisplay();
}

function resumeTimer() {
  if (timerRemainingSeconds > 0) {
    isTimerRunning = true;
    updateTimerDisplay();
  }
}

function restartTimer() {
  timerRemainingSeconds = timerTotalSeconds;
  isTimerRunning = true;
  updateTimerDisplay();
}

function closeTimer() {
  clearInterval(timerInterval);
  isTimerRunning = false;
  document.getElementById("timer-modal").classList.add("hidden");
}

// ==========================================
// 4. RANDOMIZATION & GENERATION
// ==========================================
function getRandomChallenge(category = "random", difficulty = "all") {
  let pool = CHALLENGES_DATABASE.filter(item => {
    const catMatch = (category === "random") ? true : (item.category.toLowerCase() === category.toLowerCase());
    const diffMatch = (difficulty === "all") ? true : (item.difficulty.toLowerCase() === difficulty.toLowerCase());
    return catMatch && diffMatch;
  });

  if (pool.length === 0) {
    pool = (category === "random") ? CHALLENGES_DATABASE : CHALLENGES_DATABASE.filter(c => c.category === category);
  }

  // Avoid immediately showing recently viewed challenges
  const nonRecent = pool.filter(c => !appState.recentChallengeIds.includes(c.id));
  const chosenPool = nonRecent.length > 0 ? nonRecent : pool;

  const chosen = chosenPool[Math.floor(Math.random() * chosenPool.length)];

  // Update recent list (keep last 6)
  appState.recentChallengeIds = [...appState.recentChallengeIds, chosen.id].slice(-6);
  saveData();

  return chosen;
}

function generateChallenge(isInstant = false) {
  const loadingEl = document.getElementById("loading-state");
  const cardEl = document.getElementById("challenge-card");

  if (!isInstant) {
    loadingEl.classList.remove("hidden");
    cardEl.classList.add("hidden");

    setTimeout(() => {
      loadingEl.classList.add("hidden");
      cardEl.classList.remove("hidden");
      const challenge = getRandomChallenge(appState.selectedCategory, appState.selectedDifficulty);
      appState.currentChallenge = challenge;
      renderChallenge(challenge);
      showToast("🎯 New challenge generated!");
    }, 400);
  } else {
    const challenge = getRandomChallenge(appState.selectedCategory, appState.selectedDifficulty);
    appState.currentChallenge = challenge;
    renderChallenge(challenge);
  }
}

function renderChallenge(challenge) {
  const card = document.getElementById("challenge-card");
  if (!card || !challenge) return;

  const cat = CATEGORIES_CONFIG.find(c => c.key === challenge.category) || { emoji: "🎲", name: "Challenge", color: "#7C5CFC" };
  const diffBadgeClass = `badge-${challenge.difficulty.toLowerCase()}`;
  const durationText = challenge.duration > 0 ? `⏱ ${challenge.duration >= 60 ? challenge.duration/60 + ' min' : challenge.duration + ' sec'}` : "⏱ Untimed";

  card.innerHTML = `
    <div class="card-header-tag">
      <div class="category-tag" style="background: ${cat.color}22; color: ${cat.color}">
        <span>${cat.emoji}</span>
        <span>${cat.name.toUpperCase()}</span>
      </div>
      ${challenge.duration > 0 ? `<span class="meta-badge">${durationText}</span>` : ""}
    </div>

    <h2 class="challenge-title">${challenge.title}</h2>
    <p class="challenge-desc">${challenge.description}</p>

    <div class="challenge-meta-row">
      <span class="meta-badge ${diffBadgeClass}">● ${capitalize(challenge.difficulty)}</span>
      <span class="meta-badge">${durationText}</span>
      <span class="meta-badge badge-points">⭐ ${challenge.points} Points</span>
    </div>

    <div class="card-actions-row">
      <button id="btn-start" class="btn btn-primary" onclick="handleStartChallenge()">
        <span>▶</span>
        <span>${challenge.duration > 0 ? 'Start Challenge' : 'Begin'}</span>
      </button>
      <button id="btn-another" class="btn btn-secondary" onclick="generateChallenge()">
        <span>🔄</span>
        <span>Another</span>
      </button>
      <button id="btn-complete" class="btn btn-success" onclick="handleCompleteCurrent()">
        <span>✓</span>
        <span>Completed</span>
      </button>
    </div>
  `;
}

function handleStartChallenge() {
  if (appState.currentChallenge) {
    if (appState.currentChallenge.duration > 0) {
      startTimer(appState.currentChallenge);
    } else {
      showToast(`▶ Started: ${appState.currentChallenge.title}`);
    }
  }
}

function handleCompleteCurrent() {
  if (appState.currentChallenge) {
    completeChallenge(appState.currentChallenge);
  }
}

// ==========================================
// 5. COMPLETION, STREAKS & POINTS
// ==========================================
function completeChallenge(challenge) {
  // Update Score
  appState.score += challenge.points;
  appState.completedCount++;

  // Update Streak
  const todayStr = getTodayDateString();
  updateStreak(todayStr);

  // Add to History
  appState.history.unshift({
    id: Date.now(),
    challengeId: challenge.id,
    title: challenge.title,
    category: challenge.category,
    difficulty: challenge.difficulty,
    points: challenge.points,
    timestamp: Date.now()
  });

  saveData();
  updateUiHeaderStats();
  renderHistory();
  renderStats();

  // Show Confetti & Modal Celebration
  showConfetti();
  document.getElementById("celebration-reward-pill").textContent = `+${challenge.points} Points ⭐`;
  document.getElementById("celebration-modal").classList.remove("hidden");
  showToast(`✓ Challenge completed! +${challenge.points} points`);
}

function updateStreak(todayStr) {
  const lastDate = appState.lastCompletedDate;
  if (!lastDate) {
    appState.currentStreak = 1;
    appState.bestStreak = Math.max(1, appState.bestStreak);
  } else if (lastDate === todayStr) {
    // Already did one today
    appState.currentStreak = Math.max(1, appState.currentStreak);
  } else {
    const yesterdayStr = getYesterdayDateString();
    if (lastDate === yesterdayStr) {
      appState.currentStreak++;
      appState.bestStreak = Math.max(appState.currentStreak, appState.bestStreak);
    } else {
      appState.currentStreak = 1;
      appState.bestStreak = Math.max(1, appState.bestStreak);
    }
  }
  appState.lastCompletedDate = todayStr;
}

function getTodayDateString() {
  const d = new Date();
  return `${d.getFullYear()}-${String(d.getMonth() + 1).padStart(2, '0')}-${String(d.getDate()).padStart(2, '0')}`;
}

function getYesterdayDateString() {
  const d = new Date();
  d.setDate(d.getDate() - 1);
  return `${d.getFullYear()}-${String(d.getMonth() + 1).padStart(2, '0')}-${String(d.getDate()).padStart(2, '0')}`;
}

function updateUiHeaderStats() {
  const scoreEl = document.getElementById("quick-score");
  const streakEl = document.getElementById("quick-streak");
  if (scoreEl) scoreEl.textContent = `${appState.score} pts`;
  if (streakEl) streakEl.textContent = `${appState.currentStreak} Day${appState.currentStreak === 1 ? '' : 's'}`;
}

// ==========================================
// 6. DAILY CHALLENGE
// ==========================================
function getDailyChallenge() {
  const today = getTodayDateString().replace(/-/g, "");
  const seed = parseInt(today, 10) || 20261002;
  const index = seed % CHALLENGES_DATABASE.length;
  return CHALLENGES_DATABASE[index];
}

function renderDailyChallenge() {
  const daily = getDailyChallenge();
  const card = document.getElementById("daily-challenge-card");
  const dateLabel = document.getElementById("daily-date-label");
  if (!card) return;

  const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
  dateLabel.textContent = new Date().toLocaleDateString(undefined, options);

  const cat = CATEGORIES_CONFIG.find(c => c.key === daily.category) || { emoji: "🔥", name: "Special", color: "#FFD166" };

  card.innerHTML = `
    <div class="card-header-tag">
      <div class="category-tag" style="background: ${cat.color}25; color: ${cat.color}">
        <span>${cat.emoji}</span>
        <span>${cat.name.toUpperCase()}</span>
      </div>
      <span class="badge-pill gold-badge">⭐ DOUBLE REWARD: +${daily.points * 2} PTS</span>
    </div>

    <h2 class="challenge-title">${daily.title}</h2>
    <p class="challenge-desc">${daily.description}</p>

    <div class="challenge-meta-row">
      <span class="meta-badge badge-${daily.difficulty}">● ${capitalize(daily.difficulty)}</span>
      <span class="meta-badge">⏱ ${daily.duration > 0 ? daily.duration + ' sec' : 'Untimed'}</span>
    </div>

    <div class="card-actions-row">
      <button class="btn btn-primary" onclick="startTimerForChallenge(${daily.id})">
        <span>▶ Start Daily</span>
      </button>
      <button class="btn btn-success" onclick="completeDailyChallenge(${daily.id})">
        <span>✓ Completed</span>
      </button>
    </div>
  `;
}

function startTimerForChallenge(id) {
  const found = CHALLENGES_DATABASE.find(c => c.id === id);
  if (found) {
    if (found.duration > 0) startTimer(found);
    else showToast(`▶ Started: ${found.title}`);
  }
}

function completeDailyChallenge(id) {
  const found = CHALLENGES_DATABASE.find(c => c.id === id);
  if (found) {
    completeChallenge({ ...found, points: found.points * 2 });
  }
}

// ==========================================
// 7. BROWSE & SEARCH CHALLENGES
// ==========================================
function filterAndSearchChallenges() {
  const query = (document.getElementById("challenge-search").value || "").toLowerCase().trim();
  const catFilter = document.getElementById("filter-category").value;
  const diffFilter = document.getElementById("filter-difficulty").value;
  const container = document.getElementById("challenge-list");
  const emptyState = document.getElementById("search-empty-state");

  const results = CHALLENGES_DATABASE.filter(item => {
    const matchesCat = (catFilter === "all") ? true : (item.category.toLowerCase() === catFilter.toLowerCase());
    const matchesDiff = (diffFilter === "all") ? true : (item.difficulty.toLowerCase() === diffFilter.toLowerCase());
    const matchesQuery = !query ? true : (
      item.title.toLowerCase().includes(query) ||
      item.description.toLowerCase().includes(query) ||
      item.category.toLowerCase().includes(query)
    );
    return matchesCat && matchesDiff && matchesQuery;
  });

  if (results.length === 0) {
    container.innerHTML = "";
    emptyState.classList.remove("hidden");
  } else {
    emptyState.classList.add("hidden");
    container.innerHTML = results.map(item => {
      const cat = CATEGORIES_CONFIG.find(c => c.key === item.category) || { emoji: "🎲", name: item.category };
      return `
        <div class="list-item-card" onclick="selectFromList(${item.id})">
          <div>
            <div class="list-item-top">
              <span style="font-weight:700; color:${cat.color}">${cat.emoji} ${cat.name}</span>
              <span class="meta-badge badge-points">⭐ ${item.points} pts</span>
            </div>
            <h4 class="list-item-title">${item.title}</h4>
            <p class="list-item-desc">${item.description}</p>
          </div>
          <div class="list-item-bottom">
            <span class="meta-badge badge-${item.difficulty}">● ${capitalize(item.difficulty)}</span>
            <span style="font-weight:700; color:var(--primary); font-size:0.85rem">Tap to Launch →</span>
          </div>
        </div>
      `;
    }).join("");
  }
}

function selectFromList(id) {
  const item = CHALLENGES_DATABASE.find(c => c.id === id);
  if (item) {
    appState.currentChallenge = item;
    renderChallenge(item);
    navigateTo("home");
    showToast(`🎯 Selected: ${item.title}`);
  }
}

// ==========================================
// 8. STATS & CATEGORY PROGRESS
// ==========================================
function renderStats() {
  document.getElementById("stats-total-points").textContent = appState.score;
  document.getElementById("stats-completed-count").textContent = appState.completedCount;
  document.getElementById("stats-current-streak").textContent = `${appState.currentStreak} Days`;
  document.getElementById("stats-best-streak").textContent = `${appState.bestStreak} Days`;

  // Category Progress bars
  const progressContainer = document.getElementById("category-progress-bars");
  if (!progressContainer) return;

  const validCategories = CATEGORIES_CONFIG.filter(c => c.key !== "random");
  
  progressContainer.innerHTML = validCategories.map(cat => {
    const totalInCat = 12;
    const completedInCat = new Set(
      appState.history.filter(h => h.category.toLowerCase() === cat.key.toLowerCase()).map(h => h.challengeId)
    ).size;
    const percent = Math.min(100, Math.round((completedInCat / totalInCat) * 100));

    return `
      <div class="progress-item">
        <div class="progress-header">
          <span>${cat.emoji} ${cat.name}</span>
          <span style="color:${cat.color}">${completedInCat}/${totalInCat} (${percent}%)</span>
        </div>
        <div class="progress-bar-track">
          <div class="progress-bar-fill" style="width: ${percent}%; background: ${cat.color};"></div>
        </div>
      </div>
    `;
  }).join("");
}

// ==========================================
// 9. HISTORY
// ==========================================
function renderHistory() {
  const listEl = document.getElementById("history-list");
  const emptyEl = document.getElementById("history-empty");
  if (!listEl) return;

  if (appState.history.length === 0) {
    listEl.innerHTML = "";
    emptyEl.classList.remove("hidden");
  } else {
    emptyEl.classList.add("hidden");
    listEl.innerHTML = appState.history.map(item => {
      const cat = CATEGORIES_CONFIG.find(c => c.key === item.category) || { emoji: "🎯", name: item.category };
      const timeStr = formatRelativeDate(item.timestamp);
      return `
        <div class="history-item">
          <div class="history-left">
            <span class="history-check">✓</span>
            <div>
              <div class="history-title">${item.title}</div>
              <div class="history-sub">${cat.emoji} ${cat.name} • ${timeStr}</div>
            </div>
          </div>
          <div class="history-points">+${item.points} pts</div>
        </div>
      `;
    }).join("");
  }
}

function formatRelativeDate(timestamp) {
  const diff = Date.now() - timestamp;
  if (diff < 60000) return "Just now";
  if (diff < 3600000) return `${Math.floor(diff / 60000)}m ago`;
  const d = new Date(timestamp);
  return d.toLocaleDateString(undefined, { month: 'short', day: 'numeric', hour: '2-digit', minute: '2-digit' });
}

function resetHistory() {
  appState.history = [];
  saveData();
  renderHistory();
  renderStats();
  showToast("🗑 History cleared");
}

// ==========================================
// 10. CONFETTI ANIMATION (Pure Canvas)
// ==========================================
function showConfetti() {
  const canvas = document.getElementById("confetti-canvas");
  if (!canvas) return;
  const ctx = canvas.getContext("2d");
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;

  const confettiCount = 100;
  const colors = ["#FFD166", "#00D4FF", "#7C5CFC", "#FF5C8A", "#2ED573", "#FF8533"];
  const particles = [];

  for (let i = 0; i < confettiCount; i++) {
    particles.push({
      x: Math.random() * canvas.width,
      y: -Math.random() * 200,
      vx: (Math.random() - 0.5) * 4,
      vy: Math.random() * 4 + 3,
      size: Math.random() * 8 + 6,
      color: colors[Math.floor(Math.random() * colors.length)],
      rotation: Math.random() * 360,
      rotationSpeed: (Math.random() - 0.5) * 10
    });
  }

  let animationFrame;
  let startTime = Date.now();

  function render() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    const elapsed = Date.now() - startTime;

    particles.forEach(p => {
      p.x += p.vx;
      p.y += p.vy;
      p.rotation += p.rotationSpeed;

      ctx.save();
      ctx.translate(p.x, p.y);
      ctx.rotate((p.rotation * Math.PI) / 180);
      ctx.fillStyle = p.color;
      ctx.fillRect(-p.size / 2, -p.size / 2, p.size, p.size * 0.6);
      ctx.restore();
    });

    if (elapsed < 3500) {
      animationFrame = requestAnimationFrame(render);
    } else {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      cancelAnimationFrame(animationFrame);
    }
  }

  render();
}

// ==========================================
// 11. TOAST NOTIFICATIONS
// ==========================================
function showToast(message) {
  const container = document.getElementById("toast-container");
  if (!container) return;

  const toast = document.createElement("div");
  toast.className = "toast";
  toast.textContent = message;
  container.appendChild(toast);

  setTimeout(() => {
    toast.style.opacity = "0";
    toast.style.transform = "translateX(20px)";
    setTimeout(() => toast.remove(), 300);
  }, 2800);
}

// ==========================================
// 12. THEME & NAVIGATION
// ==========================================
function toggleTheme() {
  appState.theme = appState.theme === "dark" ? "light" : "dark";
  applyTheme();
  saveData();
  showToast(appState.theme === "dark" ? "🌙 Dark mode enabled" : "☀️ Light mode enabled");
}

function applyTheme() {
  if (appState.theme === "light") {
    document.body.classList.remove("dark-theme");
    document.body.classList.add("light-theme");
    document.getElementById("theme-icon").textContent = "☀️";
  } else {
    document.body.classList.remove("light-theme");
    document.body.classList.add("dark-theme");
    document.getElementById("theme-icon").textContent = "🌙";
  }
}

function navigateTo(targetId) {
  document.querySelectorAll(".page-section").forEach(sec => sec.classList.remove("active"));
  document.querySelectorAll(".nav-link").forEach(link => link.classList.remove("active"));

  const targetSec = document.getElementById(targetId);
  const activeLink = document.querySelector(`.nav-link[data-nav="${targetId}"]`);

  if (targetSec) targetSec.classList.add("active");
  if (activeLink) activeLink.classList.add("active");

  window.scrollTo({ top: 0, behavior: "smooth" });

  // Close mobile hamburger if open
  document.getElementById("nav-menu").classList.remove("show");
}

function capitalize(str) {
  return str ? str.charAt(0).toUpperCase() + str.slice(1) : "";
}

// ==========================================
// 13. INITIALIZATION
// ==========================================
document.addEventListener("DOMContentLoaded", () => {
  loadData();
  applyTheme();
  updateUiHeaderStats();

  // Render Category Grid on Home
  const catGrid = document.getElementById("category-grid");
  catGrid.innerHTML = CATEGORIES_CONFIG.map(cat => `
    <div class="category-card ${cat.key === appState.selectedCategory ? 'active' : ''}" data-cat="${cat.key}">
      <span class="cat-emoji">${cat.emoji}</span>
      <span class="cat-title">${cat.name}</span>
    </div>
  `).join("");

  // Category Card Clicks
  catGrid.addEventListener("click", e => {
    const card = e.target.closest(".category-card");
    if (!card) return;
    const cat = card.getAttribute("data-cat");
    appState.selectedCategory = cat;
    document.querySelectorAll(".category-card").forEach(c => c.classList.remove("active"));
    card.classList.add("active");
    const found = CATEGORIES_CONFIG.find(c => c.key === cat);
    document.getElementById("selected-category-label").textContent = `${found.emoji} ${found.name}`;
  });

  // Difficulty Clicks
  const diffGroup = document.getElementById("difficulty-group");
  diffGroup.addEventListener("click", e => {
    const btn = e.target.closest(".diff-btn");
    if (!btn) return;
    document.querySelectorAll(".diff-btn").forEach(b => b.classList.remove("active"));
    btn.classList.add("active");
    appState.selectedDifficulty = btn.getAttribute("data-diff");
  });

  // Generate Button Click
  document.getElementById("generate-btn").addEventListener("click", () => generateChallenge());

  // Search input & filters
  const searchInput = document.getElementById("challenge-search");
  const clearSearchBtn = document.getElementById("clear-search-btn");
  searchInput.addEventListener("input", () => {
    clearSearchBtn.classList.toggle("hidden", !searchInput.value);
    filterAndSearchChallenges();
  });
  clearSearchBtn.addEventListener("click", () => {
    searchInput.value = "";
    clearSearchBtn.classList.add("hidden");
    filterAndSearchChallenges();
  });
  document.getElementById("filter-category").addEventListener("change", filterAndSearchChallenges);
  document.getElementById("filter-difficulty").addEventListener("change", filterAndSearchChallenges);
  document.getElementById("reset-search-btn").addEventListener("click", () => {
    searchInput.value = "";
    document.getElementById("filter-category").value = "all";
    document.getElementById("filter-difficulty").value = "all";
    clearSearchBtn.classList.add("hidden");
    filterAndSearchChallenges();
  });

  // Navigation Links
  document.querySelectorAll(".nav-link").forEach(link => {
    link.addEventListener("click", e => {
      e.preventDefault();
      const target = link.getAttribute("data-nav");
      navigateTo(target);
    });
  });

  // Hamburger Toggle
  document.getElementById("hamburger-btn").addEventListener("click", () => {
    document.getElementById("nav-menu").classList.toggle("show");
  });

  // Theme Toggle Button
  document.getElementById("theme-toggle").addEventListener("click", toggleTheme);

  // Timer Controls
  document.getElementById("close-timer-btn").addEventListener("click", closeTimer);
  document.getElementById("timer-toggle-btn").addEventListener("click", () => {
    if (isTimerRunning) pauseTimer();
    else resumeTimer();
  });
  document.getElementById("timer-restart-btn").addEventListener("click", restartTimer);
  document.getElementById("timer-finish-btn").addEventListener("click", () => {
    closeTimer();
    if (activeTimerChallenge) completeChallenge(activeTimerChallenge);
  });

  // Celebration Modal Close
  document.getElementById("celebration-close-btn").addEventListener("click", () => {
    document.getElementById("celebration-modal").classList.add("hidden");
  });

  // Clear History Modal
  const clearBtn = document.getElementById("clear-history-btn");
  const confirmModal = document.getElementById("confirm-modal");
  const cancelConfirmBtn = document.getElementById("cancel-confirm-btn");
  const acceptConfirmBtn = document.getElementById("accept-confirm-btn");

  clearBtn.addEventListener("click", () => confirmModal.classList.remove("hidden"));
  cancelConfirmBtn.addEventListener("click", () => confirmModal.classList.add("hidden"));
  acceptConfirmBtn.addEventListener("click", () => {
    confirmModal.classList.add("hidden");
    resetHistory();
  });

  // Initial Content Load
  generateChallenge(true);
  renderDailyChallenge();
  filterAndSearchChallenges();
  renderStats();
  renderHistory();
});
