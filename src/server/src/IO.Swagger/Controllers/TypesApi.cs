/*
 * Simple TripApp API
 *
 * This is a simple TripApp API
 *
 * OpenAPI spec version: 1.0.0
 * 
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Swashbuckle.SwaggerGen.Annotations;
using IO.Swagger.Models;

namespace IO.Swagger.Controllers
{ 
    /// <summary>
    /// 
    /// </summary>
    public class TypesApiController : Controller
    { 

        /// <summary>
        /// adds an ticket type
        /// </summary>
        /// <remarks>Adds an item to the system</remarks>
        /// <param name="ticketType">TicketType item to add</param>
        /// <response code="201">item created</response>
        /// <response code="400">invalid input, object invalid</response>
        /// <response code="409">item already exists</response>
        [HttpPost]
        [Route("/sergiosuperstar/TripAppSimple/1.0.0/tickets/types")]
        [SwaggerOperation("AddTicketType")]
        public virtual void AddTicketType([FromBody]TicketType ticketType)
        { 
            throw new NotImplementedException();
        }


        /// <summary>
        /// searches ticket types
        /// </summary>
        /// <remarks>By passing in the appropriate options, you can search for available ticket types in the system </remarks>
        /// <param name="searchString">pass an optional search string for looking up ticket types</param>
        /// <param name="skip">number of records to skip for pagination</param>
        /// <param name="limit">maximum number of records to return</param>
        /// <response code="200">search results matching criteria</response>
        /// <response code="400">bad input parameter</response>
        [HttpGet]
        [Route("/sergiosuperstar/TripAppSimple/1.0.0/tickets/types")]
        [SwaggerOperation("SearchTicketTypes")]
        [SwaggerResponse(200, type: typeof(List<TicketType>))]
        public virtual IActionResult SearchTicketTypes([FromQuery]string searchString, [FromQuery]int? skip, [FromQuery]int? limit)
        { 
            string exampleJson = null;
            
            var example = exampleJson != null
            ? JsonConvert.DeserializeObject<List<TicketType>>(exampleJson)
            : default(List<TicketType>);
            return new ObjectResult(example);
        }
    }
}
