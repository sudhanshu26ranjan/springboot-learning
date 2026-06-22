## dependency graph & bean(service) object creation flow:
- spring-boot startup
-  ↓
- Scan
-  ↓
-  Read Metadata
-  ↓
-  Build Dependency Graph
-  ↓
-  Determine Valid Creation Order (validate graph & detect cycles)
-  ↓
-  Instantiate/create Beans
-  ↓
-  Inject Dependencies
-  ↓
-  Application Ready
## Note: 
- B/w two independent(unrelated) beans/nodes, anyone's object can be created first. Spring (property of dependency graphs) doesn't guarantee this.
- 