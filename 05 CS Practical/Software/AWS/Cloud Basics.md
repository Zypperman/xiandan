# Cloud Basics

Cloud is needed to:

- Leverage the connectivity of the internet
- Connect all sorts of <u>Terminal devices</u> (PC > Mobile devices > IOT)
- Facilitate infrastructure for handling data.

This has led to the creation of 2 new ideas:

1. The Internet of Everything (IOE), where all devices are interconnected through servers
2. Ecosystems, where 

<details>
<summary>Terminology check: Machine types</summary>

>[!note] Terminal Device Taxonomy
>
> - PC - Personal Computers
>     - Windows - PCs developed by Microsoft
>     - Mac - PCs developed by Apple. Its OS is Unix-like.
>     - Linux - An open-sourced OS, based on the Linux Kernel, which is ["the core interface between a computer's hardware and its processes"](https://www.redhat.com/en/topics/linux/what-is-the-linux-kernel#:~:text=The%20Linux%C2%AE%20kernel%20is,resources%20as%20efficiently%20as%20possible.) . They're Not PCs, and it is also unix-like.
>     - Unix -  another OS system built by AT&T. ( Lore: [Reddit](https://www.reddit.com/r/compsci/comments/55uoi1/what_is_unix_exactly/) \| [Unix specs](https://unix.org/what_is_unix.html) )
>
> - Mobile Devices - typically run on mobile Operating systems
>     - IOS - designed by Apple
>     - Android OS - designed by Google. Runs on a modified version of the Linux kernel.
> - ARM Architecture
>     - ARM &#8594; Advanced Risc Machine
>     - RISC &#8594; reduced instruction set computing
>
>    Refers to a set of rules to dictate how the hardware works per instruction executed. (Lore: [G4G](https://www.geeksforgeeks.org/arm-processor-and-its-features/))
>
> - x86 - An alternative instruction set.
>     - RISC approach promotes efficiency for lower power
>     - CISC approach promotes performance, and is what x86 uses.
>
> - DSP - Digital Signal Processors - handles IRL signals and wave-like information (ie sound, audio, temperature) ( Lore: [analog.com](https://www.analog.com/en/lp/001/beginners-guide-to-dsp.html))
> - MIPS - Million instructions per second
>     - a way of standardising measuring the speed of a processor.
> - FPGA - Field-Programmable Gate Array
>     - enables parallel execution that isnt normally available in microcontrollers, results in fewer idle instructions. ( Lore: [PCBway](https://www.pcbway.com/blog/technology/Why_use_FPGA_for_IoT__Here_s_what_I_think_.html))

</details>

## Specific Challenges Conventional IT solves

| Conventional IT infra | Cloud |
| ----------- | ----------- |
| Slow to deploy| can quickly push stuff for deployment |
| Difficult to expand | pushing mostly involves only software |
| Generally unreliable | versions can be restored easily |
| Complex to maintain long-term | version differences are easy to oversee |
| Variable Latency due to I/O <br>bottlenecks and unpredictability |  |
| High cost for all parties |  |

## What it is

