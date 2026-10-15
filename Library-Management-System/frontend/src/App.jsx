
import { useEffect, useMemo, useState } from "react";
import "./App.css";

const API_URL = "http://localhost:8080/api/books";

const emptyForm = {
  title: "",
  author: "",
  category: "Programming",
  isbn: "",
  quantity: "1",
};

function App() {
  const [books, setBooks] = useState([]);
  const [search, setSearch] = useState("");
  const [category, setCategory] = useState("All");
  const [showForm, setShowForm] = useState(false);
  const [form, setForm] = useState(emptyForm);
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false);

  // Fetch books from Spring Boot
  useEffect(() => {
    async function fetchBooks() {
      try {
        const response = await fetch(API_URL);

        if (!response.ok) {
          throw new Error("Failed to fetch books");
        }

        const data = await response.json();
        setBooks(data);
      } catch (error) {
        console.error(error);
        setMessage("Unable to load books from backend.");
      } finally {
        setLoading(false);
      }
    }

    fetchBooks();
  }, []);

  // Search and filter
  const filteredBooks = useMemo(() => {
    const term = search.toLowerCase().trim();

    return books.filter((book) => {
      const matchesSearch =
        book.title.toLowerCase().includes(term) ||
        book.author.toLowerCase().includes(term) ||
        book.isbn.toLowerCase().includes(term);

      const matchesCategory =
        category === "All" || book.category === category;

      return matchesSearch && matchesCategory;
    });
  }, [books, search, category]);

  // Dashboard statistics
  const totalCopies = books.reduce(
    (total, book) => total + book.quantity,
    0
  );

  const availableTitles = books.filter(
    (book) => book.quantity > 0
  ).length;

  const outOfStock = books.filter(
    (book) => book.quantity === 0
  ).length;

  const categories = [
    "All",
    ...new Set(books.map((book) => book.category)),
  ];

  // Handle form inputs
  function handleChange(event) {
    setForm({
      ...form,
      [event.target.name]: event.target.value,
    });
  }

  // Add book to MySQL
  async function addBook(event) {
    event.preventDefault();

    const quantity = Number(form.quantity);

    if (
      !form.title.trim() ||
      !form.author.trim() ||
      !form.isbn.trim() ||
      !Number.isInteger(quantity) ||
      quantity < 0
    ) {
      setMessage("Please enter valid book details.");
      return;
    }

    const newBook = {
      title: form.title.trim(),
      author: form.author.trim(),
      category: form.category,
      isbn: form.isbn.trim(),
      quantity,
    };

    setSaving(true);

    try {
      const response = await fetch(API_URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newBook),
      });

      if (!response.ok) {
        throw new Error("Failed to save book");
      }

      const savedBook = await response.json();

      setBooks((previousBooks) => [
        savedBook,
        ...previousBooks,
      ]);

      setForm(emptyForm);
      setShowForm(false);
      setMessage("Book saved successfully!");
    } catch (error) {
      console.error(error);
      setMessage("Unable to save book.");
    } finally {
      setSaving(false);
    }
  }

  // Delete book from MySQL
  async function deleteBook(id) {
    const confirmed = window.confirm(
      "Are you sure you want to delete this book?"
    );

    if (!confirmed) return;

    try {
      const response = await fetch(`${API_URL}/${id}`, {
        method: "DELETE",
      });

      if (!response.ok) {
        throw new Error("Failed to delete book");
      }

      setBooks((previousBooks) =>
        previousBooks.filter((book) => book.id !== id)
      );

      setMessage("Book deleted successfully!");
    } catch (error) {
      console.error(error);
      setMessage("Unable to delete book.");
    }
  }

  return (
    <div className="app">
      {/* Sidebar */}
      <aside className="sidebar">
        <div className="brand">
          <div className="brand-logo">B</div>
          <div>
            <h2>BookNest</h2>
            <p>Library Management</p>
          </div>
        </div>

        <p className="nav-heading">MENU</p>

        <button className="nav-link active" type="button">
          <span>▦</span> Dashboard
        </button>

        <button
          className="nav-link"
          type="button"
          onClick={() =>
            document
              .getElementById("catalogue")
              ?.scrollIntoView({ behavior: "smooth" })
          }
        >
          <span>▤</span> Book Catalogue
        </button>

        <button
          className="nav-link"
          type="button"
          onClick={() =>
            setMessage("Member management will be added later.")
          }
        >
          <span>♙</span> Members
        </button>

        <button
          className="nav-link"
          type="button"
          onClick={() =>
            setMessage("Borrowing and returns will be added later.")
          }
        >
          <span>↔</span> Borrow & Return
        </button>

        <div className="sidebar-bottom">
          <div className="help-card">
            <h3>Your library, organized</h3>
            <p>
              Manage your collection from one simple dashboard.
            </p>
          </div>

          <div className="profile">
            <div className="avatar">A</div>
            <div>
              <strong>Library Admin</strong>
              <p>Administrator</p>
            </div>
          </div>
        </div>
      </aside>

      {/* Main Content */}
      <main className="main-content">
        <header className="topbar">
          <span>Workspace / Dashboard</span>
          <span className="admin-label">
            Spring Boot + MySQL
          </span>
        </header>

        <section className="page-heading">
          <div>
            <p className="eyebrow">LIBRARY OVERVIEW</p>
            <h1>Welcome back, Admin!</h1>
            <p className="subtitle">
              Here's what's happening in your library today.
            </p>
          </div>

          <button
            className="primary-button"
            type="button"
            onClick={() => {
              setShowForm(true);
              setMessage("");
            }}
          >
            + Add Book
          </button>
        </section>

        {/* Messages */}
        {message && (
          <div className="notice" role="status">
            {message}
            <button
              type="button"
              onClick={() => setMessage("")}
              aria-label="Close message"
            >
              ×
            </button>
          </div>
        )}

        {/* Statistics */}
        <section className="stats-grid">
          <div className="stat-card">
            <span>Total Book Titles</span>
            <h2>{books.length}</h2>
            <p>Books in catalogue</p>
          </div>

          <div className="stat-card">
            <span>Available Titles</span>
            <h2>{availableTitles}</h2>
            <p>Ready to borrow</p>
          </div>

          <div className="stat-card">
            <span>Out of Stock</span>
            <h2>{outOfStock}</h2>
            <p>Currently unavailable</p>
          </div>

          <div className="stat-card">
            <span>Available Copies</span>
            <h2>{totalCopies}</h2>
            <p>Total copies in stock</p>
          </div>
        </section>

        {/* Book Catalogue */}
        <section className="catalogue" id="catalogue">
          <div className="catalogue-heading">
            <div>
              <h2>Book Catalogue</h2>
              <p>Search and manage your books.</p>
            </div>

            <span className="book-count">
              {filteredBooks.length} books
            </span>
          </div>

          <div className="toolbar">
            <input
              className="search-input"
              type="search"
              placeholder="Search title, author or ISBN..."
              value={search}
              onChange={(event) =>
                setSearch(event.target.value)
              }
              aria-label="Search books"
            />

            <select
              value={category}
              onChange={(event) =>
                setCategory(event.target.value)
              }
              aria-label="Filter category"
            >
              {categories.map((item) => (
                <option key={item} value={item}>
                  {item === "All"
                    ? "All Categories"
                    : item}
                </option>
              ))}
            </select>
          </div>

          <div className="table-container">
            <table>
              <thead>
                <tr>
                  <th>BOOK DETAILS</th>
                  <th>CATEGORY</th>
                  <th>ISBN</th>
                  <th>QUANTITY</th>
                  <th>STATUS</th>
                  <th>ACTION</th>
                </tr>
              </thead>

              <tbody>
                {loading ? (
                  <tr>
                    <td
                      colSpan="6"
                      className="empty-state"
                    >
                      Loading books...
                    </td>
                  </tr>
                ) : (
                  <>
                    {filteredBooks.map((book) => (
                      <tr key={book.id}>
                        <td>
                          <div className="book-details">
                            <div className="book-icon">
                              ▤
                            </div>
                            <div>
                              <strong>
                                {book.title}
                              </strong>
                              <span>
                                {book.author}
                              </span>
                            </div>
                          </div>
                        </td>

                        <td>{book.category}</td>

                        <td className="isbn">
                          {book.isbn}
                        </td>

                        <td>{book.quantity}</td>

                        <td>
                          <span
                            className={
                              book.quantity > 0
                                ? "status available"
                                : "status unavailable"
                            }
                          >
                            {book.quantity > 0
                              ? "Available"
                              : "Out of stock"}
                          </span>
                        </td>

                        <td>
                          <button
                            className="delete-button"
                            type="button"
                            onClick={() =>
                              deleteBook(book.id)
                            }
                            aria-label={`Delete ${book.title}`}
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    ))}

                    {filteredBooks.length === 0 && (
                      <tr>
                        <td
                          colSpan="6"
                          className="empty-state"
                        >
                          No books found.
                        </td>
                      </tr>
                    )}
                  </>
                )}
              </tbody>
            </table>
          </div>

          <div className="catalogue-footer">
            Showing {filteredBooks.length} of{" "}
            {books.length} books
            <span>Connected to MySQL</span>
          </div>
        </section>

        <footer className="footer">
          Library Management System
          <span>React + Spring Boot + MySQL</span>
        </footer>
      </main>

      {/* Add Book Modal */}
      {showForm && (
        <div className="modal-backdrop">
          <section
            className="modal"
            role="dialog"
            aria-modal="true"
            aria-labelledby="form-title"
          >
            <div className="modal-heading">
              <div>
                <h2 id="form-title">
                  Add New Book
                </h2>
                <p>
                  Enter the details of the book.
                </p>
              </div>

              <button
                className="close-button"
                type="button"
                onClick={() =>
                  setShowForm(false)
                }
                aria-label="Close form"
              >
                ×
              </button>
            </div>

            <form onSubmit={addBook}>
              <label>
                Book Title
                <input
                  name="title"
                  value={form.title}
                  onChange={handleChange}
                  placeholder="Enter book title"
                  required
                />
              </label>

              <label>
                Author
                <input
                  name="author"
                  value={form.author}
                  onChange={handleChange}
                  placeholder="Enter author name"
                  required
                />
              </label>

              <label>
                Category
                <select
                  name="category"
                  value={form.category}
                  onChange={handleChange}
                >
                  <option>Programming</option>
                  <option>Computer Science</option>
                  <option>Fiction</option>
                  <option>Personal Development</option>
                  <option>Education</option>
                  <option>Other</option>
                </select>
              </label>

              <label>
                ISBN
                <input
                  name="isbn"
                  value={form.isbn}
                  onChange={handleChange}
                  placeholder="Enter ISBN"
                  required
                />
              </label>

              <label>
                Available Copies
                <input
                  name="quantity"
                  type="number"
                  min="0"
                  step="1"
                  value={form.quantity}
                  onChange={handleChange}
                  required
                />
              </label>

              <div className="modal-actions">
                <button
                  className="secondary-button"
                  type="button"
                  onClick={() =>
                    setShowForm(false)
                  }
                >
                  Cancel
                </button>

                <button
                  className="primary-button"
                  type="submit"
                  disabled={saving}
                >
                  {saving
                    ? "Saving..."
                    : "Save Book"}
                </button>
              </div>
            </form>
          </section>
        </div>
      )}
    </div>
  );
}

export default App;