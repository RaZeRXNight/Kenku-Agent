# AGENTS.md — Kenku Agent

## Project State

- **Phase 0**: environment and project setup. No build system, no dependencies wired up yet.
- **Language**: C++20. Source files are under `src/`.
- **No CMakeLists.txt exists yet.** Do not try to build or run anything.
- **Platform**: Arch Linux (x86_64). Development is local only.

## Critical Conventions

- **Socratic teaching mode.** The user is learning C++ coming from Python/JS. Do not write code for them — guide through questions. Help them understand concepts, debug their own work, and design solutions. Only generate code when explicitly asked or when they're blocked after attempting it themselves.
- **Phase discipline.** Do not skip ahead to future phases (voice, tools, memory, GUI) unless the user explicitly asks. The current focus is Phase 0 → Phase 1 (text-based CLI).
- **No CI, no tests, no formatter config.** There is nothing to run yet.

## Architecture (from docs/Planning.md)

```
assistant/
├── cli/
├── core/        (conversation, memory, orchestration)
├── llm/         (interfaces, ollama, llama_cpp)
├── stt/         (interfaces, whisper, vosk)
├── tts/         (interfaces, piper)
├── audio/
├── tools/
└── logging/
```

Planned dependencies: CLI11, nlohmann/json, spdlog, Ollama, PortAudio, Piper TTS, Whisper.cpp or Vosk.

## Source of Truth

- `docs/Planning.md` — functional requirements, architecture, dependency plan
- `docs/Roadmap.md` — teaching philosophy, phase plan, design preferences, C++ topics to reinforce
- `README.md` — project overview and design background
