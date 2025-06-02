# OBS Basics

## Post landing page 

- Preview window - where you get to see your content if you have another screen open

## Configs and Settings

### Resolution

- Base (Canvas) Resolution - what size your preview window is viewed at
- Output (Scaled) Resolution - what size recorded footage becomes

ideal is 1080p, but for performance 720 usually works. Editors ideally want 1080 but 720 is the bare minimum.

### FPS

- Default Category is Common FPS Values. Integer FPS Values lets you put in a custom fps.
    - best scenario for smooth gameplay is 120fps.
    - typically set 30 to 60, try not to 120 cuz editors workload will scale with this.
    - PAL FPS (standard in AU and EU regions) typically want 50 PAL, not 25.

### Output Configs

Use advanced mode, relevant subtab is 'Recording'

- Recording path - where your recordings will be are saved
- Recording format - use MKV (Matroska Video). MP4 and MOV are standard but not good because these formats will be corrupt if your machine crashes.
- Video Encoder - Ideally one by NVIDIA if you have an NVIDIA GPU.
    - NVIDIA NVENC - A special chip in models after 2012 (newer than GTX 600) will be used separate from one for gameplay so you can game and record smoothly.
        - HVNEC (aka H.265) - 
        - H.264 (aka AVC) - 
        - AV1 - 
    - x264 - for if you have a GPU thats pre-2012, with no dedicated video handling capability (aka no decoder or encoder core).
