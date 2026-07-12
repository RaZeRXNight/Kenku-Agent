# Kenku Agent

A local-first AI voice assistant designed to run entirely on a user's computer. The assistant will provide voice interaction, conversational AI, desktop automation, and extensibility through tools and plugins while maintaining user privacy through local inference.

The system will initially be developed as a command-line application before evolving into a desktop GUI application.

## Features

- **Voice Interaction**: Speech-to-text and text-to-speech capabilities using local models
- **Conversational AI**: Natural language understanding and response generation running locally
- **Desktop Automation**: Control applications, files, and system functions through voice commands
- **Plugin System**: Extensible architecture for adding custom tools and capabilities
- **Privacy-First Design**: All processing happens on-device with no cloud dependencies
- **CLI First**: Full functionality available through command-line interface before GUI development

## Documentation

Any further documentation and knowledge of how the codebase works will be found in [docs/](docs/)

## Design

### Background

I come from a Python and JavaScript background, so I came with the expectation that you just download packages and have them do the work. This practice showed its face when I researched alongside GPT what I should use for this process. Back and forth had me landing on the current technologies used.

This rabbit hole also had me learn CMake, because again I come from Python and JS. I thought it would be just as easy as a `requirements.txt` and `package-lock.json`. It was not that easy at all.
