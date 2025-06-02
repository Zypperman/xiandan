# Cloud Basics

Cloud is needed (in the context of the public cloud) to:

- Leverage the connectivity of the internet
- Connect all sorts of <u>Terminal devices</u> (PC > Mobile devices > IOT)
- Facilitate infrastructure for handling data.

This has led to the creation of 2 new ideas:

1. The Internet of Everything (IOE), where all devices are interconnected through servers
2. Ecosystems, where devices can now connect and communicate and unite to create more value

<!--<details>-->
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

<!--</details>-->

## Specific Challenges Conventional IT solves

| Conventional IT infra | Cloud |
| ----------- | ----------- |
| Slow to deploy / procurement takes time| can quickly push stuff for deployment |
| Difficult to expand because architecture is centralised, performance improvements generally revolve around optimizing a single node | pushing mostly involves only software |
| Generally unreliable, since hardware cant be maintained once it reaches the consumer, now software-reliant| versions can be restored easily, and mostly software is involved with the service, hardware involved is typically general purpose (ie smartwatch or smarphone) so now its more consumer reliant instead|
| Complex to maintain long-term  + devices | version differences are easy to oversee |
| Variable Latency due to I/O <br>bottlenecks and unpredictability | Latency is easier to solve since problem areas can be isolated to specific hardware |
| High cost for all parties (termed TCO, Total cost of ownership)| Companies own most of the hardware, work on a Service as a Service (SaaS) model|

## Types of technical infrastructure

Conventional Architecture

- **How it works**
    - <u>TLDR, OS handled by devices that the service has been distributed on (fully your problem)</u>
    - Services are provided with emphasis on hardware and software specs.
    - Providers needd to consider everything:
        - infrastructure
        - data centers and servers
        - network hardware
        - computers with physical connections
- **Pros and Cons**
    - resource intensive (more power, physical space and capital)
    - secure that connections are easily accounted for
- **Use Cases**
    - Enterprise applications
    - high-security info systems

Virtualized Architecture

- **How It works**
    - <u>TLDR, OS handled as a virtual container (sorta your problem)</u>
    - computer components run on a virtualization environment instead of the hardware's physical one.
    - Software becomes easier to configure with preset containers.
    - Dependence on the hardware only exists with
- **Pros and Cons**
    - resource intensive but only on hardware, since you need a machine strong enough to handle virtualization (not really a setback, most machines should be able to handle virtualization)
    - debugging might be difficult if its a client side issue
- **Use Cases**
    - both from Conventional and Cloud architecture

Cloud Architecture

- **How It works**
    - <u>TLDR, OS handled by the cloud (OS not your problem) </u>
    - Roles from conventional architecture change with:
        - All Data center information now needs to be more accessible<br>(resource silos &#8594; resource pooling)
        - architecture is now considered distributed since all deployed data centers also help with hosting
        - storage now focuses more on software requirements than hardware since its all cloud based now, operation cost is prioritized over actual hardware requirements (as in you now consider services for storage instead of hard drives)
    - hardware is not really managed by you specifically, its usually by a vendor or just another department
    - statistics are now easier to access.
- **Pros and Cons**
    - Control that isnt core to developing the service is freed from developers (ie hardware requirements)
    - statistics are easier to retrieve
    - operations can be optimized by service type from your vendor
- **Use Cases**
    - Services that need Rapid deployment and constant micromanagement, like consumer services

## Cloud Computing Definition and Features

### Definition

- A type of architecture model
- Minimal management effort required
- Enables uniquitous, convenient on-demand network access
- Service provision uses configurable, set of remote resources (ie storage, networks, servers, applications and services)
- Can be rapidly provisioned
- Minimal direct interaction with the service provider required

### Features

- **On-Demand Self-service**
    - Developers can deploy their services by interacting with vendor-owned resources, without actually contacting the vendor themselves
    - Devs can independently cofigure requirements ie. server run time, network and storage
- **Broad Network Access**
    - Most service functions are provided over the internet
    - They are also accessible via standard devices ie phones
- **Resource pooling**
    - Computing resources are controlled centrally by the vendor, and are rented out to developers
    - Devs still can dynamically realloate them as needed
    - Devs have no control over specific resources (ie you cant specifically request for the same machine)
    - Includes storage, processors, memory, network bandwidth and Virtual Machines (VMs)
        - > [!warning] How are VMs different from Docker containers?
          > [TLDR](https://aws.amazon.com/compare/the-difference-between-docker-vm/): VMs digtally pretend to be a fully-fleged device, docker containers standardise the environment you develop in.
          >
          > Its abit like how you can set up a config file for an ide.
- **Quick deployment and auto-scaling**
    - If you need to change or scale quickly, capabilities can be expanded or upgraded easily
    - resources can be rented conveniently, regardless of time and amount, your only limiting factor is cost
- **Measured services**
    - Billing is based on actual resource consumption, under one of 2 models
        - per use
        - per period (yearly/monthly)

## Tangible Technologies involved

### 1. Virtualization tech

- Foundational requirement for Cloud computing
- Usually happens on the server
- Your pretend-machine needs to handle:
    - <u>replicating hardware functions without actual hardware</u> (termed "needs to abstract hardware")
    - manage, schedule and allocate resources
- **How VMs work**:
    - A VM just a set of disk files and description files
    - all these files are in the same folder, considered 1 VM
    - Multiple VMs on a server are encapsulated, and run isolated from each other.
    - basically somewhat freeing you from hardware requirements by decoupling your software and having hardware functioons simulated.

### 2. Data storage tech

- Data-wise, cloud computing needs to be able to handle :
    - large user-bases using them
    - multiple users <u>at the same time</u> (termed "in parallel")
- Accomplished via:
    - being <u>able to process large amounts of information at a time</u><br>(termed "high throughput")
    - being <u>able to transfer data at high rate</u><br>(termed "high transmission rate")

### 3. Mass DB analysis tech

- aside from storing data, cloud computing also needs to collate the data efficiently for analysis.

- Accomplished via (solving the following problems):
    - Optimizing the <u>speed of retrieving random bits of info</u><br>(termed "random read rate")
    - Optimizing the <u>speed of changing random bits of info</u><br>(termed "data update rate")

### 4. Parallel Computing tech (Map-reduce Model)

- Map-Reduce is both a <u>programming model</u> and <u>task scheduling</u> model.
    - Named because users only need to compile Map and Reduce Functions to perform parallel computing
    - Typically adopted because its a simple model
    - Exists because cloud computing runs on a distributed computing mode &#8594; therefore needs a distributed programming mode.
    - Handles (in parallel):
        - schedulig tasks
        - computing data sets

### 5. Cloud computing (CC) management tech

Needs to solves the following problems:

- handle running a lot of applications simultaneously
- managing resources factoring in distance and sheer quantity in hardware (ie how do you handle over multiple servers)
- provide uninterrupted service

## Common Characteristics of Cloud computing (interview qn content)

1. Massive scale
    - Resources are centralised and pooled and facilitiating a cloud involves a large quantity of resources.
2. Homogenity / standardisation
    - Power utiization (ie voltage and socket interface) should be the same for various devices involved
    <!-- TODO: Figure out what this means -->
3. Virtualization (2 interpretations)
    1. Resouces can be allocated more efficiently by resizing VMs, ie if a person doesn't need so much compute, the resources that their VM can access can be modified and shared with other VM users. (accurate computing requirements)
    2. software is not solely compatible with single hardware because its decoupled, meaning you can just move your machine over to another one. (resilient computing)
4. Elastic Computing
    - IT resources can be elastically provided (requests for more or less can easily be accomodated for)
5. Low Cost software
    - Cloud computing is easier ad cheaper to set up because of market competition and requirements. Smaller establishments ie SMEs prefer this, where more services can be enjoyed for a smaller cost to maximise their earnings (with a larger margin of safety so that they can expand faster)
6. Advanced Security tech available
    - Security is high due to the large number of users with different requirements using the cloud
7. Geographical distribution
    - cloud services can be provided independent of time and space, so long as there is an internet connection.
    - servers and data centers are usually well distributed across strategic locations and regions to facilitate a high bandwidth
    - service nodes need to be capable of providing good availability globally
8. Service oriented
    - this is by design since cloud computing is considered a service model.

## Deployment models for cloud computing

- 3 main types:
    - private cloud &#8212; fully enterprise controlled
        - data in the private cloud is kept in the organisation's data center
        - incoming network traffic is firewall-protected (termed an "ingress firewall"), making the data center highly secure.
    - hybrid cloud &#8212; mix of both private and public cloud
        - utilises resources from both public and private cloud
        - involves on-premise resources, but remains as distinct entities
        - its how to ensemble benefits from both models
        - workloads can be migrated as needed
    - public cloud &#8212; entirely exposed to 3p vendor, shared with multiple other organisations
        - users get access to convenient, on-demand IT services

