# RestfulCRUDAPIPractice
Building restful CRUD API's for previously created animal gallery.

Link to Demo: 
https://uncg.instructuremedia.com/embed/2281c901-f8e8-44ac-9739-0a0fe79c0886

## API Endpoints

Base URL: http://localhost:8080/api/cats

1. / (GET)
Gets a list of all Exotic Cats in the database.
Response - A JSON array of ExoticCat objects.
[
  {
    "exoticCatId": 2,
    "name": "Canadian Lynx",
    "description": "With their distinctive ear tufts and large paws, Canadian Lynx are adapted for snowy climates.",
    "breed": "Lynx",
    "origin": "Canada & Northern US",
    "size": "Medium (18-25 lbs)",
    "lifespan": "10-15 years",
    "conservationStatus": "Least Concern",
    "careRequirements": "Special care needed for cold climate adaptation."
  },
  {
    "exoticCatId": 3,
    "name": "Savannah Cat",
    "description": "A cross between domestic cats and African Servals, Savannahs are active, intelligent, and loyal.",
    "breed": "Savannah",
    "origin": "USA",
    "size": "Large (12-25 lbs)",
    "lifespan": "12-20 years",
    "conservationStatus": "Not Evaluated",
    "careRequirements": "Very active, requires space and enrichment."
  },
  {
    "exoticCatId": 4,
    "name": "Bengal Cat",
    "description": "Bengals have stunning leopard-like markings and high energy levels.",
    "breed": "Bengal",
    "origin": "USA",
    "size": "Medium-Large (8-15 lbs)",
    "lifespan": "12-16 years",
    "conservationStatus": "Not Evaluated",
    "careRequirements": "Intelligent and playful, enjoys water activities."
  },
  {
    "exoticCatId": 5,
    "name": "Caracal",
    "description": "Distinctive black-tufted ears and reddish-gold coat make Caracals striking.",
    "breed": "Caracal",
    "origin": "Africa & Asia",
    "size": "Medium-Large (25-50 lbs)",
    "lifespan": "12-17 years",
    "conservationStatus": "Least Concern",
    "careRequirements": "Requires experienced handlers with proper facilities."
  }
]

2. /{id} (GET)
Gets an individual Exotic Cat by its ID. Each cat is identified by a numeric exoticCatId.
Parameters

Path Variable: id <Long> - REQUIRED

Response - A single ExoticCat object.

  {
    "exoticCatId": 3,
    "name": "Savannah Cat",
    "description": "A cross between domestic cats and African Servals, Savannahs are active, intelligent, and loyal.",
    "breed": "Savannah",
    "origin": "USA",
    "size": "Large (12-25 lbs)",
    "lifespan": "12-20 years",
    "conservationStatus": "Not Evaluated",
    "careRequirements": "Very active, requires space and enrichment."
  }

3. /search (GET)
Gets a list of cats whose name contains the given search string (case-insensitive).
Parameters

Query parameter: name <String> - REQUIRED

Example Request
http://localhost:8080/api/cats/search?name=lynx
Response - A JSON array of ExoticCat objects.
  {
    "exoticCatId": 2,
    "name": "Canadian Lynx",
    "description": "With their distinctive ear tufts and large paws, Canadian Lynx are adapted for snowy climates.",
    "breed": "Lynx",
    "origin": "Canada & Northern US",
    "size": "Medium (18-25 lbs)",
    "lifespan": "10-15 years",
    "conservationStatus": "Least Concern",
    "careRequirements": "Special care needed for cold climate adaptation."
  }

4. /breed/{breed} (GET)
Gets a list of cats filtered by breed category.
Parameters

Path variable: breed <String> - REQUIRED

Example Request
http://localhost:8080/api/cats/breed/Caracal
Response - A JSON array of ExoticCat objects.
  {
    "exoticCatId": 5,
    "name": "Caracal",
    "description": "Distinctive black-tufted ears and reddish-gold coat make Caracals striking.",
    "breed": "Caracal",
    "origin": "Africa & Asia",
    "size": "Medium-Large (25-50 lbs)",
    "lifespan": "12-17 years",
    "conservationStatus": "Least Concern",
    "careRequirements": "Requires experienced handlers with proper facilities."
  }

5. / (POST)
Create a new Exotic Cat entry.
Request Body
An ExoticCat object. Note: Do not include exoticCatId as it is auto-generated.
{
  "name": "Bengal Cat",
  "description": "Bengals have stunning leopard-like markings and high energy levels.",
  "breed": "Bengal",
  "origin": "USA",
  "size": "Medium-Large (8-15 lbs)",
  "lifespan": "12-16 years",
  "conservationStatus": "Not Evaluated",
  "careRequirements": "Intelligent and playful, enjoys water activities."
}
Response - The newly created ExoticCat (Status: 201 Created).
{
  "exoticCatId": 3,
  "name": "Bengal Cat",
  "description": "Bengals have stunning leopard-like markings and high energy levels.",
  "breed": "Bengal",
  "origin": "USA",
  "size": "Medium-Large (8-15 lbs)",
  "lifespan": "12-16 years",
  "conservationStatus": "Not Evaluated",
  "careRequirements": "Intelligent and playful, enjoys water activities."
}

6. /{id} (PUT)
Update an existing Exotic Cat.
Parameters

Path Variable: id <Long> - REQUIRED

Request Body
An ExoticCat object with the updates. All fields should be included.
{
  "name": "Serval",
  "description": "UPDATED: Known for their spotted coat and incredible jumping abilities up to 10 feet high!",
  "breed": "Serval",
  "origin": "Sub-Saharan Africa",
  "size": "Medium-Large (20-40 lbs)",
  "lifespan": "15-20 years",
  "conservationStatus": "Least Concern",
  "careRequirements": "Requires experienced owners and proper permits."
}
Updated fields appear after ExoticCat object receives 200 OK.

7. /{id} (DELETE)
Delete an existing Exotic Cat.
Parameters

Path Variable: id <Long> - REQUIRED

Example Request
http://localhost:8080/api/cats/3
Response
Status: 204 No Content (empty response body)

### Running the Application
Prerequisites

Java 21 or higher
Maven
Neon Tech account with PostgreSQL database