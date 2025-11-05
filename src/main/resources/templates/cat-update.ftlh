<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update ${cat.name}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/cats">🐆 Exotic Cats Gallery</a>
        </div>
    </nav>

    <div class="container mt-5">
        <!-- ERROR MESSAGE (in case form submission fails) -->
        <#if errorMessage??>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Error!</strong> ${errorMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </#if>

        <div class="card">
            <div class="card-header bg-warning">
                <h1 class="mb-0">Update ${cat.name}</h1>
            </div>
            <div class="card-body">
                <form action="/cats/update" method="post">
                    <!-- CRITICAL: Hidden ID field -->
                    <input type="hidden" name="exoticCatId" value="${cat.exoticCatId}">
                    
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="name" 
                                       name="name" 
                                       value="${cat.name}"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="breed" class="form-label">Breed: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="breed" 
                                       name="breed" 
                                       value="${cat.breed}"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="origin" class="form-label">Origin: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="origin" 
                                       name="origin" 
                                       value="${cat.origin}"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="size" class="form-label">Size: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="size" 
                                       name="size" 
                                       value="${cat.size}"
                                       required>
                            </div>
                        </div>
                        
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="lifespan" class="form-label">Lifespan: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="lifespan" 
                                       name="lifespan" 
                                       value="${cat.lifespan}"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="conservationStatus" class="form-label">Conservation Status:</label>
                                <input type="text" 
                                       class="form-control" 
                                       id="conservationStatus" 
                                       name="conservationStatus" 
                                       value="${cat.conservationStatus!""}">
                            </div>
                            
                            <div class="mb-3">
                                <label for="description" class="form-label">Description: <span class="text-danger">*</span></label>
                                <textarea class="form-control" 
                                          id="description" 
                                          name="description" 
                                          rows="4" 
                                          required>${cat.description}</textarea>
                            </div>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <label for="careRequirements" class="form-label">Care Requirements:</label>
                        <textarea class="form-control" 
                                  id="careRequirements" 
                                  name="careRequirements" 
                                  rows="3">${cat.careRequirements!""}</textarea>
                    </div>
                    
                    <div class="d-flex gap-2">
                        <button type="submit" class="btn btn-warning">
                            ✓ Update Cat
                        </button>
                        <a href="/cats/${cat.exoticCatId}" class="btn btn-secondary">
                            Cancel
                        </a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="alert alert-info mt-3">
            <strong>Note:</strong> You are editing cat ID #${cat.exoticCatId}. 
            Fields marked with <span class="text-danger">*</span> are required.
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>