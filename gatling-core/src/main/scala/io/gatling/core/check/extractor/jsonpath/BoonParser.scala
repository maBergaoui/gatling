/**
 * Copyright 2011-2013 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.core.check.extractor.jsonpath

import org.boon.json.implementation.{ JsonParserCharArray, JsonFastParser }

import io.gatling.core.config.GatlingConfiguration.configuration

object BoonParser extends JsonParser {

	def newLazyChopParser = {
		// FIXME use regular parser for now
		val jsonParser = new JsonParserCharArray(null.asInstanceOf[org.boon.core.reflection.fields.FieldsAccessor])
		//		val jsonParser = new JsonFastParser(null, false, false, true)
		jsonParser.setCharset(configuration.core.charSet)
		jsonParser
	}

	def parse(bytes: Array[Byte]) = newLazyChopParser.parse(bytes)
	def parse(string: String) = newLazyChopParser.parse(string)
}
