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
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using Swashbuckle.SwaggerGen.Annotations;
using IO.Swagger.Models;
using Microsoft.AspNetCore.Http;
using IO.Swagger.Data;
using Microsoft.Extensions.Logging;
using IO.Swagger.Logging;
using Microsoft.EntityFrameworkCore;

namespace IO.Swagger.Controllers
{
    /// <summary>
    /// 
    /// </summary>
    public class ValidationApiController : Controller
    {
        private readonly TripAppContext _context;
        private readonly ILogger _logger;

        /// <summary>
        /// Constructor method.
        /// </summary>
        /// <param name="context"></param>
        /// <param name="logger"></param>
        public ValidationApiController(TripAppContext context, ILogger<ValidationApiController> logger)
        {
            _context = context;
            _logger = logger;
        }

        /// <summary>
        /// adds an ticket validation item
        /// </summary>
        /// <remarks>Adds an item to the system</remarks>
        /// <param name="ticketValidation">TicketValidation item to add</param>
        /// <response code="201">item created</response>
        /// <response code="400">invalid input, object invalid</response>
        /// <response code="409">an existing item already exists</response>
        [HttpPost]
        [Route("/sergiosuperstar/TripAppSimple/1.0.0/tickets/validation")]
        [SwaggerOperation("AddTicketValidation")]
        public virtual IActionResult AddTicketValidation([FromBody]TicketValidation ticketValidation)
        {
            // TODO ftn: Add validation to the ticketValidation parameter!!!
            // Return 400 - BadRequest if not valid!

            if (_context.Validations.FirstOrDefault(t => t.Id == ticketValidation.Id) != null)
            {
                return StatusCode(StatusCodes.Status409Conflict); // 409 already exists!
            }

            TicketPurchase ticket = _context.Purchases.FirstOrDefault(p => p.Code == ticketValidation.Ticket.Code);

            if (ticket == null)
            {
                return StatusCode(StatusCodes.Status404NotFound);
            }

            if (ticket.EndDateTime < DateTime.Now)
            {
                return StatusCode(StatusCodes.Status406NotAcceptable, ticket);
            }

            try
            {
                ticketValidation.Ticket = ticket;
                ticketValidation.IsValid = true;
                ticketValidation.ValidationDateTime = DateTime.Now.ToUniversalTime();

                Random r = new Random();
                int rInt = r.Next(1, 1000000000);
                ticketValidation.Id = rInt; 

                _context.Validations.Add(ticketValidation);
                _context.Entry(ticketValidation.Controller).State = Microsoft.EntityFrameworkCore.EntityState.Unchanged;
                _context.SaveChanges();
                return new ObjectResult(ticket);
                //return Created(Request.Host.ToString(), ticketValidation); // 201 Created successfuly.
            }
            catch (Exception)
            {
                _logger.LogError(LoggingEvents.INSERT_ITEM, "AddTicketType({ticketValidation}) NOT ADDED", ticketValidation);
                return StatusCode(StatusCodes.Status500InternalServerError);
            }
        }


        /// <summary>
        /// searches tickets validations
        /// </summary>
        /// <remarks>By passing in the appropriate options, you can search for available ticket validations in the system </remarks>
        /// <param name="searchString">pass an optional search string for looking up ticket validations</param>
        /// <param name="skip">number of records to skip for pagination</param>
        /// <param name="limit">maximum number of records to return</param>
        /// <response code="200">search results matching criteria</response>
        /// <response code="400">bad input parameter</response>
        [HttpGet]
        [Route("/sergiosuperstar/TripAppSimple/1.0.0/tickets/validation")]
        [SwaggerOperation("SearchValidations")]
        [SwaggerResponse(200, type: typeof(List<TicketValidation>))]
        public virtual IActionResult SearchValidations([FromQuery]string searchString, [FromQuery]int? skip, [FromQuery]int? limit)
        {
            int id;
            if (!int.TryParse(searchString, out id))
            {
                return StatusCode(StatusCodes.Status400BadRequest);
            }
            try
            {
                var validations = _context.Validations.Where(c => c.Id == id).ToList();
                return new ObjectResult(validations);
            }
            catch (Exception)
            {
                _logger.LogError(LoggingEvents.LIST_ITEMS, "SearchValidations({searchString}) NOT FOUND", searchString);
                return StatusCode(StatusCodes.Status500InternalServerError);
            }
        }


        /// <summary>
        /// searches tickets validations
        /// </summary>
        /// <remarks>By passing in the appropriate options, you can search for available ticket validations in the system </remarks>
        /// <param name="searchString">pass an optional search string for looking up ticket validations</param>
        /// <param name="skip">number of records to skip for pagination</param>
        /// <param name="limit">maximum number of records to return</param>
        /// <response code="200">search results matching criteria</response>
        /// <response code="400">bad input parameter</response>
        [HttpGet]
        [Route("/sergiosuperstar/TripAppSimple/1.0.0/tickets/validation/controller")]
        [SwaggerOperation("SearchValidations")]
        [SwaggerResponse(200, type: typeof(List<TicketValidation>))]
        public virtual IActionResult SearchControlerValidations([FromQuery]string searchString, [FromQuery]int? skip, [FromQuery]int? limit)
        {
            int id;
            if (!int.TryParse(searchString, out id))
            {
                return StatusCode(StatusCodes.Status400BadRequest);
            }
            try
            {
                var validations = _context.Validations.Include(c => c.Controller).Include(t => t.Ticket).Include(tt => tt.Ticket.Type).Include(tt => tt.Ticket.User).Where(u => u.Controller.Id == id);
                return new ObjectResult(validations);
            }
            catch (Exception)
            {
                _logger.LogError(LoggingEvents.LIST_ITEMS, "SearchValidations({searchString}) NOT FOUND", searchString);
                return StatusCode(StatusCodes.Status500InternalServerError);
            }
        }
    }
}
