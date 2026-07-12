# Kenku Agent Project Overview

## Project Description

A local-first AI voice assistant designed to run entirely on a user's computer. The assistant will provide voice interaction, conversational AI, desktop automation, and extensibility through tools and plugins while maintaining user privacy through local inference.

The system will initially be developed as a command-line application before evolving into a desktop GUI application.

## Project Goals

### Primary Goals

- Run locally on user hardware
- Support voice and text interaction
- Support offline operation where possible
- Be modular and extensible
- Allow multiple AI backends
- Allow multiple STT/TTS providers
- Provide safe desktop automation capabilities

### Secondary Goals

- Persistent memory
- Knowledge vault / RAG
- Wake-word activation
- Persona switching
- GUI desktop application

### Out of Scope (Version 1)

These items should explicitly be excluded for now:

- Cloud-hosted inference
- Mobile applications
- Multi-user support
- Voice cloning
- Training custom LLMs
- Autonomous internet browsing
- Fully autonomous agents
- Smart home integration

## Functional Requirements

### FR-1 Text Interaction

The assistant shall:

- Accept text input
- Generate responses using an LLM backend
- Display responses in terminal output

Example

> hello
> Assistant: Hello.

### FR-2 Voice Output

The assistant shall:

- Convert generated responses into speech
- Play generated speech through system audio devices

Initial provider:

- Piper TTS

Future providers:

- XTTS
- Kokoro
- OpenAI TTS (optional)

### FR-3 Speech Recognition

The assistant shall:

- Accept microphone input
- Convert speech to text
- Pass transcription to the conversation engine

Initial candidates:

- Whisper.cpp
- Vosk

Decision deferred until prototyping.

### FR-4 Conversation Management

The assistant shall:

- Maintain active conversation context
- Support configurable context window sizes
- Preserve conversation history during a session

### FR-5 LLM Provider Abstraction

The system shall support interchangeable LLM backends.

Initial providers:

- Ollama

Future providers:

- llama.cpp
- OpenAI-compatible APIs

Example:

```cpp
class ILLMProvider
{
public:
    virtual std::string Generate(...) = 0;
};
```

### FR-6 Tool Execution

The assistant shall support tool invocation.

Initial tools:

- Read file
- Write file
- List directory

Future tools:

- Execute shell commands
- Open applications
- Search local documents

### FR-7 Safety Controls

The assistant shall:

- Require confirmation for destructive operations
- Log tool executions
- Restrict dangerous shell commands

Example:

```
Delete file?
[Y/N]
```

### FR-8 Logging

The assistant shall log:

- User requests
- Responses
- Tool executions
- Errors

## Non-Functional Requirements

### NFR-1 Privacy

The system should operate entirely locally whenever possible.

User data should not be transmitted externally unless explicitly configured.

### NFR-2 Performance

Target latency:

| Component | Target |
| ----------- | -------- |
| STT | < 1 second |
| LLM Response Start | < 2 seconds |
| TTS Start | < 500ms |
| Total Response | < 4 seconds |

### NFR-3 Extensibility

New:

- STT providers
- TTS providers
- LLM providers
- Tools

should be implementable without modifying core business logic.

### NFR-4 Cross Platform

Initial target:

- Linux

Future support:

- Windows
- macOS

## Technical Requirements

### Language

C++20

### Build System

CMake

Required concepts:

- `add_library`
- `add_executable`
- `target_link_libraries`
- `add_subdirectory`

### Dependencies

#### Core

| Dependency | Purpose |
| ----------- | --------- |
| CLI11 | CLI parsing |
| nlohmann/json | JSON |
| spdlog | Logging |

#### AI

| Dependency | Purpose |
| ----------- | --------- |
| Ollama | Initial LLM |
| llama.cpp | Future backend |

#### Audio

| Dependency | Purpose |
| ----------- | --------- |
| PortAudio | Recording/playback |
| Piper | TTS |
| Whisper.cpp or Vosk | STT |

## Proposed Architecture

```
assistant
│
├── cli
│
├── core
│   ├── conversation
│   ├── memory
│   └── orchestration
│
├── llm
│   ├── interfaces
│   ├── ollama
│   └── llama_cpp
│
├── stt
│   ├── interfaces
│   ├── whisper
│   └── vosk
│
├── tts
│   ├── interfaces
│   └── piper
│
├── audio
│
├── tools
│
└── logging
```
