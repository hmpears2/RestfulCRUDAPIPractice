<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Exotic Cat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/cats">🐆 Exotic Cats Gallery</a>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-success text-white">
                <h1 class="mb-0">Add New Exotic Cat</h1>
            </div>
            <div class="card-body">
                <form action="/cats/new" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="name" 
                                       name="name" 
                                       placeholder="e.g., Simba"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="breed" class="form-label">Breed: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="breed" 
                                       name="breed" 
                                       placeholder="e.g., Bengal Tiger"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="origin" class="form-label">Origin: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="origin" 
                                       name="origin" 
                                       placeholder="e.g., India, Bangladesh"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="size" class="form-label">Size: <span class="text-danger">*</span></label>
                                <input type="text" 
                                       class="form-control" 
                                       id="size" 
                                       name="size" 
                                       placeholder="e.g., Large (200-300kg)"
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
                                       placeholder="e.g., 10-15 years"
                                       required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="conservationStatus" class="form-label">Conservation Status:</label>
                                <input type="text" 
                                       class="form-control" 
                                       id="conservationStatus" 
                                       name="conservationStatus" 
                                       placeholder="e.g., Endangered">
                            </div>
                            
                            <div class="mb-3">
                                <label for="description" class="form-label">Description: <span class="text-danger">*</span></label>
                                <textarea class="form-control" 
                                          id="description" 
                                          name="description" 
                                          rows="4" 
                                          placeholder="Brief description of the cat..."
                                          required></textarea>
                            </div>
                        </div>
                    </div>
                    
                    <div class="mb-3">
                        <label for="careRequirements" class="form-label">Care Requirements:</label>
                        <textarea class="form-control" 
                                  id="careRequirements" 
                                  name="careRequirements" 
                                  rows="3" 
                                  placeholder="Special care needs, diet, habitat..."></textarea>
                    </div>
                    
                    <div class="d-flex gap-2">
                        <button type="submit" class="btn btn-success">
                            ✓ Add Cat
                        </button>
                        <a href="/cats" class="btn btn-secondary">
                            Cancel
                        </a>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="alert alert-info mt-3">
            <strong>Note:</strong> Fields marked with <span class="text-danger">*</span> are required.
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>