#! bb

(def chars ["\uee06" "\uee07" "\uee08" "\uee09" "\uee0a" "\uee0b"])

(loop [i 0]
  (print
    (str
      ; \u001b \u000d " " ;; ESC CR Moves the cursor to column zero
      \u001b "[2J"
      \u001b "[H"

      ;; normal
      "\n  Other fonts ["
      (str/join
        (for [j (range 2 17)]
          (if (<= j i) "#" ".")))
      "] "
      (nth "|/-\\" (mod i 4))
      " "

      ;; Fira Code
      "\n\n  Fira Code   "
      (if (= 0 i) \uee00 \uee03) ;; Progress start
      (str/join
        (for [j (range 2 17)]
          (if (<= j i) \uee04 \uee01)))
      (if (= 17 i) \uee05 \uee02)
      " "
      (nth chars (mod i 6))
      " "
      #_#_(-> i (/ 17.0) (* 100) (int)) "%"
      "       "))
  (flush)
  (Thread/sleep 200)
  (recur (mod (inc i) 18)))