package com.volnoboy;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by Reuven on 2/22/15.
 */
public class AuditInterceptor extends EmptyInterceptor {

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("Saving an entity!");
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public void postFlush(Iterator entities) {
		System.out.println("Entity has been flushed!");
		super.postFlush(entities);
	}

}
