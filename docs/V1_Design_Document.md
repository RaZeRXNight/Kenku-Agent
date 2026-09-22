# Kenku Agent Project Overview

## Project Description

A local-first AI voice assistant designed to run entirely on a user's computer.
The assistant will provide voice interaction, conversational AI, desktop
automation, and extensibility through tools and plugins while maintaining user
privacy through local inference.

## Requirements

The program must be able to be modular and extensible, allow multiple ai backends
and allow multiple STT/TTS providers. It may also provide the following:

- Persistent memory
- Knowledge vault / RAG
- Wake-word activation
- Persona switching
- GUI desktop application

### Audio

For audio the assistant will accept text input, generate responses using
an `LLM Backend` and stream responses to an output. For Voice Output will
convert generated responses into speech audio and play the audio through system
devices. The assistant will also accept microphone input, convert speech to
text and pass the output to the `Conversation Engine`.

### Conversation Management

The assistant will maintain active conversation context, support configurable
context window sizes and preserve conversation history during a session.

### LLM Usage

The assistant shall support tool invocation.

- Read and Write files, and list Directories. In the future the program will
  execute shell commands, open applications and search local documents.
- Support Interchangeable LLM Backends (Ollama, llama_cpp, Cloud Providers).
- The assistant will Require confirmation for destructive operations, Log tool executions
  and restrict dangerous shell commands.
- The assistant shall log user requests, responses, tool executions and errors.

## Architecture

```
src
├── cli
├── core
│   ├── conversation
│   ├── memory
│   └── orchestration
├── llm
│   ├── interfaces
│   ├── ollama
│   └── llama_cpp
├── stt
│   ├── interfaces
│   ├── whisper
│   └── vosk
├── tts
│   ├── interfaces
│   └── piper
├── audio
├── tools
└── logging
```

### Conversation Orchestration

This Engine will handle orchestration of the `LLM Engine`, TTS, STT, Sessions

### LLM Engine

This Engine will handle orchestration of the LLM, handling tool usage, context
management, and memory.

### Audio I/O

The project will use `Vosk Server / SDK` for speech to text, temporarily use
[Google Cloud's tts](https://docs.cloud.google.com/java/docs/reference/google-cloud-texttospeech/latest/overview) for text to speech.

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
