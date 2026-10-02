# 🎯 Random Challenge Generator (ChallengeGen)

A modern, responsive, mini-game inspired application that generates safe, spontaneous, and fun challenges across 10 categories with timers, score tracking, daily streaks, search, and celebratory animations!

## ✨ Features

- **🎲 10 Challenge Categories**:
  - 😂 Funny (Robot mode, commentator, silent comedy, question master)
  - 🧠 Brain (Mental math, memory grid, riddles, tongue twisters)
  - 💪 Fitness (Safe squats, planks, jumping jacks, stretches)
  - 🎨 Creative (Blindfolded doodling, micro-stories, haikus)
  - 🎤 Social (Kind compliments, memory check-in, gratitude notes)
  - 🎮 Gaming (No damage runs, random loadouts, rhythm challenge)
  - 📚 Study (15-min focus sprints, Feynman technique, flashcard blitz)
  - 😈 Dare (Safe celebrity impressions, Shakespearean drama, clean jokes)
  - ⚡ Quick Challenges (Under 2 minutes for instant action)
  - 🎲 Random (Shuffle across all categories)

- **⚡ Difficulty & Reward System**:
  - 🟢 **Easy**: 10–30 points
  - 🟡 **Medium**: 30–70 points
  - 🔴 **Hard**: 70–100 points

- **⏱ Interactive Countdown Timer**:
  - Circular progress ring + digital MM:SS clock
  - Pause, Resume, Restart, and Finish Early controls
  - Auto-completion celebration on timer zero

- **🎉 Celebration & Confetti**:
  - Lightweight canvas confetti animation
  - Points reward popup dialog
  - Interactive toast notifications

- **🔥 Daily Streak & Stats Tracking**:
  - Live streak counter (e.g., 🔥 3 Day Streak)
  - Longest streak and all-time score
  - Category completion progress bars
  - Rank progression (Novice, Veteran, Grandmaster, Legend)

- **🌟 Synchronized Challenge of the Day**:
  - Date-seeded daily challenge consistent for 24 hours
  - Double bonus points multiplier

- **🔍 Search & Filter Vault**:
  - Real-time search by challenge title, description, or keyword
  - Multi-filtering by category and difficulty
  - Direct launch into challenge

- **📜 Completion History**:
  - Chronological history with relative timestamps
  - Clear history with confirmation modal

- **🌙 Dark & Light Themes**:
  - Modern dark cyberpunk dashboard palette (`#0B1020`, `#151B2F`, `#7C5CFC`, `#00D4FF`, `#FFD166`)
  - Crisp light mode toggle

- **📱 Responsive & Cross-Platform**:
  - Native Android app with Jetpack Compose, Room persistence, and Material 3
  - Standalone pure Web version (`index.html`) using semantic HTML5, CSS3, and ES6+ JavaScript with zero heavy dependencies!

## 🚀 How to Run

### Web Version:
Simply open `index.html` in any modern web browser (Chrome, Firefox, Safari, Edge). All progress is automatically stored in `localStorage`.

### Android App:
Build and run using Gradle:
```bash
./gradlew installDebug
```
or run directly on the Streaming Android Emulator in Google AI Studio.
