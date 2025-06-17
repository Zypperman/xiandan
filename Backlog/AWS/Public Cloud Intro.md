# The Public Cloud (an overview)

## Core Features and elements

- Shared resource service (good to think about a service like google colab)
- Cloud functionality is handled by 3P provider over the public internet
- Cloud functionality involves providing resources ie compute
- Pricing varies from free to pay per use
- No initial IT infrastructure is needed on the user's part
    - This reducees digital barriers and IT costs, good for start-ups

### Why Start Ups find Public cloud favorable

- Total Cost of ownership is low = operating model is more lightweight and costs are more manageable
- Company doesn't need to handle costs associated with maintaining their own server, hardware and infra since theyre not that big to need one yet
    - inital setup is expensive alongside managing various liability risks and maintenance complexity ie. fire safety, power etc
    - Not efficient to do privately + scaling hardware is resource-intensive
- more viable for development since its better for testing and verification, aligning with the objectives of Continuous Integration and Continuous Development (CI/CD)
- More accessible
- Security and privacy levels are also a lot higher than if they established a private cloud themselves
    - Providers usually would have passed more security and privacy certifications.
- **Main benefit: Frees up Operations and Management of IT Infrastructure.**

## Public Cloud Architecture

![Public could diagram of resource control rights](https://s7280.pcdn.co/wp-content/uploads/2017/09/saas-vs-paas-vs-iaas.png)

>[!note] Diagram issues
> Virtuaization is actually available for IAAS.

Resources you typically dont have control over:

- Servers
- Storage devices
- Network devices
- Firewalls

Three types of as-a-service (XaaS) that you can access (usually via console):

- Infrastructure (IaaS)
    - Computing virtualization
    - Storage virtualization
    - Network virtualization
    - Basically anything abstract low level resources
- Platform (PaaS)
    - Services from IaaS
    - Relational Database Services (RDS ie mysql, but over the cloud)
    - Cloud Application Engine (CAE, ie. AWS lambdas)
    - Docker (for containerizing development environments)
- Software (SaaS)
    - Services from IaaS
    - DevClouds
    - Workspaces
    - Third party services

Cloud services can also be offered as:

- Business Ops platforms
- Ops and management platforms

----
Quick update: Since the thing is due today i'll just transfer content tomorrow and read to pass the test first.