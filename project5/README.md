# General
    - #### Team#:99 react
    
    - #### Names: Soham Ravindra Lokhande (46816606) and Swami Sivananda Nanendla (62389275)
    
    - #### Project 5 Video Demo Link: https://youtu.be/jjpRsP2XF_s

   

Soham Ravindra Lokhande (StudentID : 46816606)

Tested the local set-up  of the main branch and checked the  local setup correctness. Worked on the Docker and tested the Docker image locally to ensure it functions as expected. Worked on the Kubernetes deployment.  Partnered and worked on the Set up a Kubernetes cluster on AWS.  Worked on the Kubernetes and ensured that  all services are correctly configured and operational. configured the  JMeter scripts based  to simulate user interactions and load. Reconfigured the Kubernetes cluster by adjusting the number of nodes and pods. Maintained the Github repository. 


Swami Sivananda Nadendla  (StudentID : 62389275 )

Created the  Docker image following the “Dockerized” branch guidelines. Deployed  the Docker image on an AWS EC2 instance. Worked together on the Set up a Kubernetes cluster on AWS. Tested the Kubernetes. Prepared the  necessary Kubernetes deployment, service, and ingress YAML configurations. Migrate the MySQL database to Kubernetes. Conducted the  initial JMeter tests locally to validate the setup. checked the performance testing on the Kubernetes cluster and documented the results.
Video Recording and uploading.


JMeter Test Results:-

1 Control Plane + 3 Worker nodes + 1 master MySQL pod + 1 slave MySQL pod + 2 Fabflix pods -> 
GUI for 10 secs:-
Throughput-476.893/minute

Non-GUI for 10 secs:-
summary +      1 in 00:00:01 =    1.1/s Avg:   810 Min:   810 Max:   810 Err:     0 (0.00%) 
summary +     72 in 00:00:30 =    2.4/s Avg:  3615 Min:   107 Max: 25308 Err:     0 (0.00%) 
summary =     73 in 00:00:30 =    2.4/s Avg:  3577 Min:   107 Max: 25308 Err:     0 (0.00%) 

1 Control Plane + 4 Worker nodes + 1 master MySQL pod + 1 slave MySQL pod + 3 Fabflix pods -> 
GUI for 10 secs:-
Throughput-456.571/minute

Non-GUI for 10 secs:-
summary +     90 in 00:00:39 =    2.3/s Avg:  2720 Min:   155 Max: 21617 Err:     0 (0.00%) 
summary +     68 in 00:00:27 =    2.5/s Avg:  5661 Min:   204 Max: 23411 Err:     0 (0.00%) 
summary =    158 in 00:01:06 =    2.4/s Avg:  3986 Min:   155 Max: 23411 Err:     0 (0.00%)
    

