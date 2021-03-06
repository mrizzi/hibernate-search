/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.elasticsearch.logging.impl;

import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.SortField;
import org.hibernate.search.exception.SearchException;
import org.hibernate.search.util.logging.impl.ClassFormatter;
import org.jboss.logging.annotations.FormatWith;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

/**
 * Hibernate Search Elasticsearch backend log abstraction.
 *
 * @author Gunnar Morling
 */
@MessageLogger(projectCode = "HSEARCH")
public interface Log extends org.hibernate.search.util.logging.impl.Log {

	@Message(id = ES_BACKEND_MESSAGES_START_ID + 1,
			value = "Cannot execute query '%2$s', as targeted entity type '%1$s' is indexed through a non-Elasticsearch backend")
	SearchException cannotRunEsQueryTargetingEntityIndexedWithNonEsIndexManager(@FormatWith(ClassFormatter.class) Class<?> entityType, String query);

	@Message(id = ES_BACKEND_MESSAGES_START_ID + 2,
			value = "Lucene query '%1$s' cannot be transformed into equivalent Elasticsearch query" )
	SearchException cannotTransformLuceneQueryIntoEsQuery(Query query);

	@Message(id = ES_BACKEND_MESSAGES_START_ID + 3,
			value = "Lucene filter '%1$s' cannot be transformed into equivalent Elasticsearch query" )
	SearchException cannotTransformLuceneFilterIntoEsQuery(Filter filter);

	@Message(id = ES_BACKEND_MESSAGES_START_ID + 4,
			value = "The sort order RANGE_DEFINITION_ORDER should not be sent to the Elasticsearch backend" )
	SearchException cannotSendRangeDefinitionOrderToElasticsearchBackend();

	@Message(id = ES_BACKEND_MESSAGES_START_ID + 5,
			value = "The SortType '%1$s' cannot be used with a null sort field name")
	SearchException cannotUseThisSortTypeWithNullSortFieldName(SortField.Type sortType);

	@Message(id = ES_BACKEND_MESSAGES_START_ID + 6,
			value = "Empty phrase queries are not supported")
	SearchException cannotQueryOnEmptyPhraseQuery();

}
