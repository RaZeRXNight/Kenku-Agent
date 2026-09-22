# Kenku Agent Project Overview

## Project Description

A local-first AI voice assistant designed to run entirely on a user's computer.
The assistant will provide voice interaction, conversational AI, desktop
automation, and extensibility through tools and plugins while maintaining user
privacy through local inference.

The system will initially be developed as a command-line application before
evolving into a desktop GUI application.

## Requirements

The program must be able to fulfill the following requirements:

- Run locally on user hardware
- Support voice and text interaction
- Support offline operation where possible
- Be modular and extensible
- Allow multiple AI backends
- Allow multiple STT/TTS providers
- Provide safe desktop automation capabilities

With the following being secondary goals:

- Persistent memory
- Knowledge vault / RAG
- Wake-word activation
- Persona switching
- GUI desktop application

### FR-1 Text Interaction

The assistant will accept text input, generate responses using an `LLM Backend`
and stream responses to an output.

### FR-2 Voice Output

The assistant will convert generated responses into speech audio and
play the audio through system devices.

### FR-3 Speech Recognition

The assistant accept microphone input, convert speech to text and pass
the output to the `Conversation Engine`.

### FR-4 Conversation Management

The assistant will maintain active conversation context, support configurable
context window sizes and preserve conversation history during a session.

The system shall support interchangeable LLM backends.

### FR-6 Tool Execution

The assistant shall support tool invocation.

- Read and Write files, and list Directories. In the future the program will
  execute shell commands, open applications and search local documents.

### FR-7 Safety Controls

The assistant will Require confirmation for destructive operations, Log tool executions
and restrict dangerous shell commands.

### FR-8 Logging

The assistant shall log user requests, responses, tool executions and errors.

## Architecture

```
src
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

Target latency:

| Component          | Target      |
| ------------------ | ----------- |
| STT                | < 1 second  |
| LLM Response Start | < 2 seconds |
| TTS Start          | < 500ms     |
| Total Response     | < 4 seconds |

### Conversation Engine

### LLM Engine

### Audio I/O

The project will use `Vosk Server / SDK` for speech to text, temporarily use
[Google Cloud's tts](https://docs.cloud.google.com/java/docs/reference/google-cloud-texttospeech/latest/overview)
for text to speech

## Construction

## System Testing

## Future Improvements

These items should explicitly be excluded for now:

- Cloud-hosted inference
- Mobile applications
- Multi-user support
- Voice cloning
- Training custom LLMs
- Autonomous internet browsing
- Fully autonomous agents
- Smart home integration
