#!/bin/bash

# Defaults
TEST_CATEGORY="${TEST_CATEGORY:-REGRESSION}"
BROWSER="${BROWSER:-CHROME}"
THREAD_COUNT="${THREAD_COUNT:-2}"
GRID_URL="${GRID_URL:-http://hub:4444/wd/hub}"

# Extract HUB base URL from GRID_URL
# Example: http://hub:4444/wd/hub  ->  http://hub:4444
HUB_BASE_URL=$(echo "$GRID_URL" | sed 's|\(/wd/hub\).*||')

echo "-------------------------------------------"
echo "TEST_CATEGORY : ${TEST_CATEGORY}"
echo "BROWSER       : ${BROWSER}"
echo "THREAD_COUNT  : ${THREAD_COUNT}"
echo "GRID_URL      : ${GRID_URL}"
echo "HUB_BASE_URL  : ${HUB_BASE_URL}"
echo "-------------------------------------------"

# Wait for Selenium Hub readiness
echo "Checking if Selenium Hub is ready..."
count=0
while [ "$(curl -s ${HUB_BASE_URL}/status | jq -r '.value.ready')" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"

  if [ "$count" -ge 30 ]; then
      echo "**** HUB IS NOT READY WITHIN 30 SECONDS ****"
      exit 1
  fi

  sleep 1
done

echo "Selenium Grid is up and running. Running the tests..."

# Start the tests
java -cp 'libs/*' \
     -DTEST_CATEGORY="${TEST_CATEGORY}" \
     -DGRID_URL="${GRID_URL}" \
     -DBROWSER="${BROWSER}" \
     org.testng.TestNG \
     -threadcount "${THREAD_COUNT}" \
     test-suite/testng.xml
