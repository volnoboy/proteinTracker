package com.volnoboy;

import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;

/**
 * Created by Reuven on 2/22/15.
 */
public class LoadEventListener extends DefaultLoadEventListener{
	@Override
	public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {

		System.out.println("Entity loaded:");
		System.out.println(event.getEntityId());
	}
}
