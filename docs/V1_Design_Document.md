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
text and pass the output to the `Conversation Engine`. There sill also be
wake-word activation in the final product.

### LLM Usage

The assistant shall support tool invocation.

- Read and Write files, and list Directories. In the future the program will
  execute shell commands, open applications and search local documents.
- Support Interchangeable LLM Backends (Ollama, llama_cpp, Cloud Providers).
- The assistant will Require confirmation for destructive operations, Log tool executions
  and restrict dangerous shell commands.
- The assistant shall log user requests, responses, tool executions and errors.

### Personalization

The assistant will also maintain persistent memory, which leads to building out
a knowledge vault through RAG. The user will also be able to change the persona
of the voice assistant.

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

### LLM Engine

This Engine will handle orchestration of the LLM, handling tool usage, context
management, and memory.

#### Context & Memory Management

### Audio I/O

The project will use `Vosk Server / SDK` for speech to text, temporarily use
[Google Cloud's tts](https://docs.cloud.google.com/java/docs/reference/google-cloud-texttospeech/latest/overview) for text to speech.

## Construction

### LLM Engine

The LLM Engine will be the first component developed, this alongside CLI
capabilities. This will be a Class that abstracts and handles the LLM Backend.
It will also be used for the follow:

- Handling Network Calls to the LLM Provider.
- Handling Model Swapping.
- Be the interface between the Audio I/O and the Models.

The class will be constructed as

```java

// Java uses Records, which are similar to tuples in other languages.
record message(string sender, string message) {
  public class message{
    private string sender;
    private string message;

    public message(string sender, string message) {
      this.sender = sender;
      this.message = message;
    }
  }
}

public class llm_interface {
  private string provider;
  private string model;
  private message[] conversation;
}

``
```

### Conversation Context Management

The Context Management Class will handle how agents will manage their memory. This will be
achieved through using sqlite3 for persistent storage.

### CLI Tooling

### GUI Development

## System Testing

The testing suite used with be [JUnit](https://docs.junit.org/6.1.3/overview.html).

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
