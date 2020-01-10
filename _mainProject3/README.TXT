------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Rideshare Network Simulation
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT: Run from main of SimulationController of filename in .txt containing simuation parameters
                           Format of time should be:
                           outputDataFileName
                           SimulationName,NumberOfVertices(int),BranchingFactor(float),minEdgeValue(int),maxEdgeValue(int),numOfDrivers(int),PassengerAdditionProbability(float),SatisfactionFactor(int) 
                           ...(Another simulation parameters)
                           ...
                           
                           NB: The satisfactionFactor determines how far new Passengers will be assigned to Driver object. This would affect the nature of satisfaction of Customers.
                           Example
                           
                           outputTest1
                           NYCDOWNNTOWN,1000,4.9,10,18,300,0.9259,6
                           SIERRAVISTADOWNTOWN,1000,3.75,2,12,150,0.009792,4
                           GUATIERDOWNTOWN,1000,3.0,1,6,100,0.006140465,2
                           GUATIEROVERALL,1000,2.0,1,6,100,0.006140465,1
                           SIERRAVISTAOVERALL,5000,3.0,2,8,200,0.00734375,3
                           NYCOVERALL,10000,4.0,6,13,500,0.55556,5
AUTHORS:
USER INSTRUCTIONS:
