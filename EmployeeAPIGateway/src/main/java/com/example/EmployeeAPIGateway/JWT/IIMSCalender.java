package com.example.EmployeeAPIGateway.JWT;

import org.springframework.boot.system.SystemProperties;

public class IIMSCalender {

    private volatile static IIMSCalender iimsCalender;

    //using volatile keyword here make sure that the multiple thread read the instance properly
    // and ensure the multiple copies are being accessed by different threads.

    private IIMSCalender() {
        if(iimsCalender != null)
        {
            throw new IllegalArgumentException("not allowed");
        }
    }

    //to protect from reflection attack : we use a null check inn private constructor and throw exception

    public synchronized static IIMSCalender getInstance() {

        //when multiple thread approach this condition at once ,
        // this can cause ,creation of multiple instance and break singleton
        //so we introduce two check singleton design to ensure multi thread compliance
  /*    if( iimsCalender == null) {
          iimsCalender = new IIMSCalender();
      }
        return iimsCalender;

    } */
        //rather than method level Syncronization we can go for segment level Syncronization

      if(iimsCalender == null)
            synchronized (IIMSCalender.class)    // this ensures only while null check the segments gte locked
            {
                if(iimsCalender == null)
                {
                    iimsCalender = new IIMSCalender() ;
                }
            }
        return iimsCalender;

    }
    public void getSingletonInfo()
    {
        System.out.println("Singleton Info" );
    }

}
